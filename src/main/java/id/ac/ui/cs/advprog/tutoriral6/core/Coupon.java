package id.ac.ui.cs.advprog.tutoriral6.core;


import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Setter
@Getter
public class Coupon {
    private String id;
    private double discount;
    private boolean isRedeemed;

    public Coupon(double discount) {
        this.discount = discount;
    }

    @Async("asyncExecutor")
    public CompletableFuture<Double> redeemAsync(double price) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (!isRedeemed) {
                isRedeemed = true;
                return price - (discount/100) * price;
            }
            return -1.0;
        });
    }
}
