package id.ac.ui.cs.advprog.tutoriral6.repository;
import org.springframework.scheduling.annotation.Async;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public abstract class BaseRepository<T> {
    Map<String, T> map = new HashMap<>();

    String generateCode() {
        //Taken from: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public abstract void  add(T object) throws InterruptedException;

    @Async
    public abstract CompletableFuture<T> get(String id) throws InterruptedException;

    public List<T> all() {
        return map.values().stream().toList();
    }
}
