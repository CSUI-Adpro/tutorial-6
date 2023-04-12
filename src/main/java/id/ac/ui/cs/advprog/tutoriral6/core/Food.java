package id.ac.ui.cs.advprog.tutoriral6.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Food {
    private String id;
    private String name;
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
