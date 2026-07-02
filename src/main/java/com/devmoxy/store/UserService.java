package com.devmoxy.store;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    UserRepository userRepository;
    NotificationService notificationService;

    public UserService( UserRepository userRepository, NotificationService notificationService) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

    public void Register(User user){
       if(userRepository.findByEmail(user.getEmail()) != null){
           System.out.println("You are an existing user");
       }
       userRepository.save(user);
       notificationService.send("You are successfully registered", user.getEmail());
    }
}
