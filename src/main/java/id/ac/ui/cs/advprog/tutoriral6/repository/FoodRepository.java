package id.ac.ui.cs.advprog.tutoriral6.repository;
import id.ac.ui.cs.advprog.tutoriral6.core.Food;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public class FoodRepository extends BaseRepository<Food>{

    @Override
    public void add(Food object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    public CompletableFuture<Food> get(String id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return map.get(id);
        });
    }
}
