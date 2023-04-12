package id.ac.ui.cs.advprog.tutoriral6.core;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Coupon {
    private String id;
    private double discount;
    private boolean isRedeemed;

    public Coupon(double discount) {
        this.discount = discount;
    }

    public double redeem(double price) throws InterruptedException {
        Thread.sleep(3000);

        if (!isRedeemed) {
            isRedeemed = true;
            return price - (discount/100) * price;
        }
        return -1;
    }
}
