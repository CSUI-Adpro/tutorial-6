package id.ac.ui.cs.advprog.tutoriral6.service;

import id.ac.ui.cs.advprog.tutoriral6.core.*;
import id.ac.ui.cs.advprog.tutoriral6.core.dto.PaymentDto;
import id.ac.ui.cs.advprog.tutoriral6.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService implements IPaymentService{

    private final FoodRepository foodRepository;
    private final CouponRepository couponRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final PaymentLogRepository paymentLogRepository;


    @Autowired
    PaymentService(FoodRepository foodRepository,
                   CouponRepository couponRepository,
                   CustomerRepository customerRepository,
                   OrderRepository orderRepository,
                    PaymentLogRepository paymentLogRepository
    ) {
        this.foodRepository = foodRepository;
        this.couponRepository = couponRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.paymentLogRepository = paymentLogRepository;
    }

    @Override
    public List<Food> allFood() {
        return foodRepository.all();
    }

    @Override
    public List<Coupon> allCoupon() {
        return couponRepository.all();
    }

    @Override
    public List<Customer> allCustomer() {
        return customerRepository.all();
    }

    @Override
    public List<Order> allOrder() {
        return orderRepository.all();
    }

    @Override
    public CompletableFuture<Order> pay(PaymentDto paymentDto) {
        CompletableFuture<Food> foodFuture = foodRepository.get(paymentDto.getFoodId());
        CompletableFuture<Coupon> couponFuture = couponRepository.get(paymentDto.getCouponId());
        CompletableFuture<Customer> customerFuture = customerRepository.get(paymentDto.getCustomerId());

        return CompletableFuture.allOf(foodFuture, couponFuture, customerFuture)
                .thenComposeAsync(ignored -> {
                    Food food = foodFuture.join();
                    return couponFuture.thenApplyAsync(coupon -> {
                        Customer customer = customerFuture.join();

                        try {
                            reduceCustomerBalance(customer, food, coupon);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return new Order(customer.getName(), food.getName(), coupon.getDiscount());
                    });
                });
    }

    private void reduceCustomerBalance(Customer customer, Food food, Coupon coupon) throws InterruptedException {
        double foodPrice = food.getPrice();
        double discountedPrice = coupon.redeem(foodPrice);
        boolean couponIsUsed = discountedPrice == -1 ;
        if (couponIsUsed) {
            customer.setBalance(customer.getBalance() - discountedPrice);
            paymentLogRepository.add(new PaymentLog(customer, food, coupon, discountedPrice));
        }
        else {
            customer.setBalance(customer.getBalance() - foodPrice);
            paymentLogRepository.add(new PaymentLog(customer, food, foodPrice));
        }
    }
}
