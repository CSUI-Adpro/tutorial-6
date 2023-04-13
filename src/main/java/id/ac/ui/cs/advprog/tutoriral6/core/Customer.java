package id.ac.ui.cs.advprog.tutoriral6.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Setter
@Getter
public class Customer {
    private String id;
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Async("asyncExecutor")
    public synchronized CompletableFuture<Void> setBalanceAsync(double balance) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.balance = balance;
        });
    }
}
