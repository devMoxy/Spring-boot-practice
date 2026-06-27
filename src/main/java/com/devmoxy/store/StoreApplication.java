package com.devmoxy.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
    @Controller
    public static class HomeController {
        @Value("${spring.application.name}")
        private String appName;

        @RequestMapping("/")
        public String index(){
            System.out.println(appName);
            String viewName = getViewName();
            return viewName;
        }

        private String getViewName(){
            return "index.html";
        }
    }
}
