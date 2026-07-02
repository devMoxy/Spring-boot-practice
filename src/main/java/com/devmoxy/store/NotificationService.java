package com.devmoxy.store;

import org.springframework.stereotype.Service;

@Service("notifService")
public interface NotificationService{

    public void send(String message, String recipientEmail);
}
