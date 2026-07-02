package com.devmoxy.store;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

@Repository("userMemory")
public class InMemoryUserRepository implements UserRepository {
    final HashMap<String, User> users  = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println("Saving user.... " + user );
        users.put(user.getEmail(), user);
    }

    public User findByEmail(String email){
        return users.getOrDefault(email, null);
    }

}
