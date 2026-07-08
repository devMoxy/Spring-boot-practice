package com.devmoxy.store;
import com.devmoxy.store.domain.Addresses;
import com.devmoxy.store.domain.User;
import com.devmoxy.store.domain.profiles;
import com.devmoxy.store.domain.tags;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        //ConfigurableApplicationContext context   = SpringApplication.run(StoreApplication.class, args);
        var user = User.builder()
                .id(1)
                .name("Moxy")
                .email("moxygmal")
                .build();

        var profile = profiles.builder()
                .id(1)
                .bio("upcoming SWE")
                .phone_number(4343)
                .loyalty_points(2)
                .build();

        user.setProfile(profile);
        profile.setUser(user);

        System.out.println(user);
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
