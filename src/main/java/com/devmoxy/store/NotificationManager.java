package com.devmoxy.store;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationManager {

    private final Map<String, NotificationService> notificationService;

    public NotificationManager(Map<String, NotificationService> notificationService){
        this.notificationService = notificationService;
    }

    public void sendMessage(String input){
        NotificationService targetService = notificationService.get(input.toLowerCase());

        if(targetService != null){
            targetService.message("My name is dexMoxy");
        }else{
            System.out.println("Wrong input");
        }
    }

}
