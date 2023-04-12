package id.ac.ui.cs.advprog.tutoriral6.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentLog {
    private String id;
    private String couponId;
    private boolean useCoupon;
    private double discount;

    private String foodName;
    private double foodPrice;

    private double totalPayment;

    private String customerName;
    private double customerBalanceAfterPayment;

    public PaymentLog(Customer customer, Food food, double totalPayment) {
        this.customerName = customer.getName();
        this.customerBalanceAfterPayment = customer.getBalance();

        this.foodName = food.getName();
        this.foodPrice = food.getPrice();

        this.totalPayment = totalPayment;

        this.couponId = "";
        this.useCoupon = false;
        this.discount = 0;
    }

    public PaymentLog(Customer customer, Food food, Coupon coupon, double totalPayment) {
        this.customerName = customer.getName();
        this.customerBalanceAfterPayment = customer.getBalance();

        this.foodName = food.getName();
        this.foodPrice = food.getPrice();

        this.couponId = coupon.getId();
        this.useCoupon = true;
        this.discount = coupon.getDiscount();

        this.totalPayment = totalPayment;
    }
}
