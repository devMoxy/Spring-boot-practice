package com.devmoxy.store.repositories;

import com.devmoxy.store.domain.Addresses;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends CrudRepository<Addresses, Long> {
}