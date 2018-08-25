package com.acepabdurohman.belajarthymeleafspring.repository;

import com.acepabdurohman.belajarthymeleafspring.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select p from Product p")
    List<Product> findAllProduct();
}
