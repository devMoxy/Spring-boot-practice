package com.devmoxy.store.services;

import com.devmoxy.store.domain.Addresses;
import com.devmoxy.store.domain.Category;
import com.devmoxy.store.domain.Product;
import com.devmoxy.store.domain.User;
import com.devmoxy.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service("userService")
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressesRepository addressesRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("moxy")
                .email("moxyGmail")
                .password("password")
                .build();

        if(entityManager.contains(user)){
            System.out.println("Persistent");
        }else{
            System.out.println("Transient");
        }

        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println("Persistent");
        }else{
            System.out.println("Transient");
        }
    }

    @Transactional
    public void showRelatedEntities(){
        var profile  = profileRepository.findById(9L).orElseThrow();
        System.out.println(profile.getUser());
    }

    @Transactional
    public void getAddress(){
        var address = addressesRepository.findById(9L).orElseThrow();
        System.out.println(address);
    }

    public void persistRelated(){
        var user = User.builder()
                .name("BSaks")
                .email("BSaks07Mail")
                .password("password")
                .build();

        var address = Addresses.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip(123345)
                .build();

        user.addAddress(address);

        userRepository.save(user);

        address.setUser(user);
        addressesRepository.save(address);
    }

    @Transactional
    public void deleteRelated(){
        var user = userRepository.findById(11L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
    }

    public void manageProducts(){
        var user = userRepository.findById(1L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addFavoriteProduct);
        userRepository.save(user);
    }

    @Transactional
    public void updateProductRepository(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
    }

    @Transactional
    public void fetchProducts(){
        var products  = productRepository.findProductsByPrice(BigDecimal.valueOf(1), BigDecimal.valueOf(10));
        products.forEach(System.out::println);
    }

    @Transactional
    public void findAllTags(){
        var users = userRepository.findAll();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }
}
