package id.ac.ui.cs.advprog.tutoriral6.repository;

import id.ac.ui.cs.advprog.tutoriral6.core.Coupon;
import id.ac.ui.cs.advprog.tutoriral6.core.PaymentLog;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentLogRepository extends BaseRepository<PaymentLog>{
    @Override
    public void add(PaymentLog object) {
        object.setId(generateCode());
        map.put(object.getId(), object);
    }

    @Override
    public PaymentLog get(String id) throws InterruptedException {
        return map.get(id);
    }
}
