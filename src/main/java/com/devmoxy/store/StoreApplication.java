package com.devmoxy.store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context   = SpringApplication.run(StoreApplication.class, args);
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
