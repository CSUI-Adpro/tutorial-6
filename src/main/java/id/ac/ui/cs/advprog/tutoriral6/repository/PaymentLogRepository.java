package id.ac.ui.cs.advprog.tutoriral6.repository;

import id.ac.ui.cs.advprog.tutoriral6.core.Coupon;
import id.ac.ui.cs.advprog.tutoriral6.core.Food;
import id.ac.ui.cs.advprog.tutoriral6.core.PaymentLog;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class PaymentLogRepository extends BaseRepository<PaymentLog>{
    @Override
    public synchronized void add(PaymentLog object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    @Async
    public synchronized CompletableFuture<PaymentLog> get(String id) {
        return CompletableFuture.completedFuture(map.get(id));
    }
}
