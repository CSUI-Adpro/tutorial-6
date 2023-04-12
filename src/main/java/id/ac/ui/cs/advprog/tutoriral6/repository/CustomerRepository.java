package id.ac.ui.cs.advprog.tutoriral6.repository;
import id.ac.ui.cs.advprog.tutoriral6.core.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends BaseRepository<Customer>{

    @Override
    public void add(Customer object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    public Customer get(String id) throws InterruptedException {
        Thread.sleep(3500);
        return map.get(id);
    }
}
