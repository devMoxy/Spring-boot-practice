package com.devmoxy.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context   = SpringApplication.run(StoreApplication.class, args);
        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendMessage("email");
    }

//    @Controller
//    public static class HomeController {
//        @Value("${spring.application.name}")
//        private String appName;
//
//        @RequestMapping("/")
//        public String index(){
//            System.out.println(appName);
//            String viewName = getViewName();
//            return viewName;
//        }
//
//        private String getViewName(){
//            return "index.html";
//        }
//    }
}
