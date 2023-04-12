package id.ac.ui.cs.advprog.tutoriral6.Controller;

import id.ac.ui.cs.advprog.tutoriral6.core.Coupon;
import id.ac.ui.cs.advprog.tutoriral6.repository.PaymentLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = {"log","log/"})

public class PaymentLogController {
    private final PaymentLogRepository paymentLogRepository;

    @Autowired
    PaymentLogController(PaymentLogRepository paymentLogRepository) {
        this.paymentLogRepository = paymentLogRepository;
    }

    @GetMapping("")
    public String allLogs(Model model) {
        model.addAttribute("allLog",paymentLogRepository.all());
        return "all_log";
    }

}
