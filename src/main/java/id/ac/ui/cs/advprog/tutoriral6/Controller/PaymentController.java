package id.ac.ui.cs.advprog.tutoriral6.Controller;

import id.ac.ui.cs.advprog.tutoriral6.core.Coupon;
import id.ac.ui.cs.advprog.tutoriral6.core.Order;
import id.ac.ui.cs.advprog.tutoriral6.core.dto.PaymentDto;
import id.ac.ui.cs.advprog.tutoriral6.repository.OrderRepository;
import id.ac.ui.cs.advprog.tutoriral6.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping(path={"order","order/"})
public class PaymentController {

    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    @Autowired
    PaymentController(PaymentService paymentService,
                      OrderRepository orderRepository) {
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("")
    public String allOrder(Model model) {
        model.addAttribute("allOrder",paymentService.allOrder());
        return "all_order";
    }


    @Async
    @PostMapping(path={"pay","pay/"})
    public CompletableFuture<String> pay(@RequestParam String foodId,
                                         @RequestParam String couponId,
                                         @RequestParam String customerId ) {
        PaymentDto paymentDto = new PaymentDto(couponId, customerId, foodId);
        long start = System.nanoTime();
        CompletableFuture<Order> orderFuture = paymentService.pay(paymentDto);
        return orderFuture.thenApplyAsync(order -> {
            long end = System.nanoTime();
            order.setTimeTaken( (double) (end - start) / 1_000_000_000);
            orderRepository.add(order);
            return "redirect:/order";
        });
    }

    @GetMapping(path={"pay","pay/"})
    public String payForm(Model model) {
        model.addAttribute("allFood",paymentService.allFood());
        model.addAttribute("allCustomer",paymentService.allCustomer());
        model.addAttribute("allCoupon",paymentService.allCoupon());

        return "payment_form";
    }

}
