package id.ac.ui.cs.advprog.tutoriral6.repository;

import id.ac.ui.cs.advprog.tutoriral6.core.Coupon;
import org.springframework.stereotype.Repository;

@Repository
public class CouponRepository extends BaseRepository<Coupon>{

    @Override
    public void add(Coupon object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    public Coupon get(String id) throws InterruptedException {
        Thread.sleep(1000);
        return map.get(id);
    }
}
