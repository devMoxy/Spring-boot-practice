package com.devmoxy.store;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService{
    public void message(String message){
        System.out.println("Email sent");
        System.out.println(message);
    }
}
