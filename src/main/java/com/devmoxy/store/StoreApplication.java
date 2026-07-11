package com.devmoxy.store;
import com.devmoxy.store.domain.User;
import com.devmoxy.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context   = SpringApplication.run(StoreApplication.class, args);
        var repository = context.getBean(UserRepository.class);

        repository.deleteAll();
    }
}
