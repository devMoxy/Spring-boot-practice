package com.devmoxy.store;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService{
    public void message(String message){
        System.out.println("SMS sent");
        System.out.println(message);
    }
}
