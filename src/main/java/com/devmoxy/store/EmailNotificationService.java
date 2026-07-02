package com.devmoxy.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService{
    String recipientEmail;
    private final AppConfig appConfig;

    public EmailNotificationService(AppConfig appConfig){
        this.appConfig = appConfig;
    }

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Email sent to " + recipientEmail);
        System.out.println(message);
        System.out.println("Server port is " + appConfig.getServerPort());
        System.out.println("Context path is " + appConfig.getContextPath());
    }

}
