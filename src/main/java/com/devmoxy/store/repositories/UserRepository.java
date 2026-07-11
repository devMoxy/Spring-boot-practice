package com.devmoxy.store.repositories;

import com.devmoxy.store.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
