package com.devmoxy.store.repositories;

import com.devmoxy.store.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}