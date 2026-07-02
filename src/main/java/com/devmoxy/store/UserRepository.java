package com.devmoxy.store;

import org.springframework.stereotype.Service;

@Service("userRepo")
public interface UserRepository {
    public void save(User user);
    User findByEmail(String email);
}
