package id.ac.ui.cs.advprog.tutoriral6.repository;

import id.ac.ui.cs.advprog.tutoriral6.core.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class OrderRepository extends BaseRepository<Order>{
    @Override
    public void add(Order object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    @Async
    public CompletableFuture<Order> get(String id) {
        return CompletableFuture.supplyAsync(() -> map.get(id));
    }
}
