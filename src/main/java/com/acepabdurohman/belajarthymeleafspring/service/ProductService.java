package com.acepabdurohman.belajarthymeleafspring.service;

import com.acepabdurohman.belajarthymeleafspring.dto.ProductAddRequest;
import com.acepabdurohman.belajarthymeleafspring.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    void addOrUpdateProduct(ProductAddRequest productAddRequest);

    Product findById(Integer id);

    void delete(Integer id);
}
