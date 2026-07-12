package com.devmoxy.store.repositories;

import com.devmoxy.store.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}