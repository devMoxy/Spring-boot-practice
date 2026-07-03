package com.devmoxy.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
public class StoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context   = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.Register(new User (1, "devMoxy", "devmoxy@gmail.com", "devMoxy123"));

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
