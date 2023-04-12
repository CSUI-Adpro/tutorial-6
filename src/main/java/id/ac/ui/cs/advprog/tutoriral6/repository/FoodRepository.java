package id.ac.ui.cs.advprog.tutoriral6.repository;
import id.ac.ui.cs.advprog.tutoriral6.core.Food;
import org.springframework.stereotype.Repository;

@Repository
public class FoodRepository extends BaseRepository<Food>{

    @Override
    public void add(Food object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    public Food get(String id) throws InterruptedException {
        Thread.sleep(2000);
        return map.get(id);
    }
}
