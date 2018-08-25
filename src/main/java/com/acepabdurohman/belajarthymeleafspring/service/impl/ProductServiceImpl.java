package com.acepabdurohman.belajarthymeleafspring.service.impl;

import com.acepabdurohman.belajarthymeleafspring.model.Product;
import com.acepabdurohman.belajarthymeleafspring.repository.ProductRepository;
import com.acepabdurohman.belajarthymeleafspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAllProduct();
    }
}
