package com.devmoxy.store.repositories;

import com.devmoxy.store.domain.Category;
import com.devmoxy.store.domain.Product;
import com.devmoxy.store.dtos.ProductSummary;
import com.devmoxy.store.dtos.ProductSummaryDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameLike (String name);
    List<Product> findByName(String name);

    List<Product> findByPrice(BigDecimal price);

    @Procedure("findProductsByPrice")
    List<Product> findProductsByPrice(@Param("min")BigDecimal min, @Param("max")BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max order by p.name")
    List<Product> countProducts (@Param("min")BigDecimal min, @Param("max")BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    @Query("select p from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);

    Object findProductsByPrice(BigDecimal price);
}