package id.ac.ui.cs.advprog.tutoriral6;

import id.ac.ui.cs.advprog.tutoriral6.core.Food;
import id.ac.ui.cs.advprog.tutoriral6.repository.FoodRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final FoodRepository foodRepository;

    @Autowired
    DataInitializer(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @PostConstruct
    public void init() {
        foodRepository.add(new Food("Cinnamon",25_000.00));
        foodRepository.add(new Food("Bibimbap",50_000.00));
        foodRepository.add(new Food("Goulash",39_000.00));
        foodRepository.add(new Food("Pho",125_00.00));
    }

}
