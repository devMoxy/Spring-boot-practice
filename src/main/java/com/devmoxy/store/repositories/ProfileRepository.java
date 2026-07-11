package com.devmoxy.store.repositories;

import com.devmoxy.store.domain.profiles;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<profiles, Long> {
}