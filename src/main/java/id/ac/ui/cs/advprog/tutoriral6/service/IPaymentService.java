package id.ac.ui.cs.advprog.tutoriral6.service;

import id.ac.ui.cs.advprog.tutoriral6.core.Coupon;
import id.ac.ui.cs.advprog.tutoriral6.core.Customer;
import id.ac.ui.cs.advprog.tutoriral6.core.Food;
import id.ac.ui.cs.advprog.tutoriral6.core.Order;
import id.ac.ui.cs.advprog.tutoriral6.core.dto.PaymentDto;

import java.util.List;

public interface IPaymentService {
    List<Food> allFood();
    List<Coupon> allCoupon();
    List<Customer> allCustomer();
    List<Order> allOrder();
    Order pay(PaymentDto paymentDto) throws InterruptedException;
}
