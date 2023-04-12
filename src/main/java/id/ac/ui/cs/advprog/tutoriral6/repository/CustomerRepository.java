package id.ac.ui.cs.advprog.tutoriral6.repository;
import id.ac.ui.cs.advprog.tutoriral6.core.Customer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class CustomerRepository extends BaseRepository<Customer>{

    @Override
    public void add(Customer object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    public CompletableFuture<Customer> get(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return map.get(id);
        });
    }
}
