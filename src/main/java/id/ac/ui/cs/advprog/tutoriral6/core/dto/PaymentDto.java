package id.ac.ui.cs.advprog.tutoriral6.core.dto;

import lombok.Getter;

@Getter
public class PaymentDto {
    private String couponId;
    private String customerId;
    private String foodId;

    public PaymentDto(String couponId, String customerId, String foodId) {
        this.couponId = couponId;
        this.customerId = customerId;
        this.foodId = foodId;
    }

}
