package id.ac.ui.cs.advprog.tutoriral6.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private String id;
    private String customerName;
    private String foodName;
    private double discount;
    private double timeTaken;

    public Order(String customerName, String foodName, double discount) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.discount = discount;
    }
}
