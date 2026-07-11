package com.devmoxy.store.services;

import com.devmoxy.store.domain.Addresses;
import com.devmoxy.store.domain.User;
import com.devmoxy.store.repositories.AddressesRepository;
import com.devmoxy.store.repositories.ProfileRepository;
import com.devmoxy.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("userService")
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressesRepository addressesRepository;

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

}
