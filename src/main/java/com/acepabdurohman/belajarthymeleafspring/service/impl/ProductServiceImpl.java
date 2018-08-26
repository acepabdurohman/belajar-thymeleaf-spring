package com.acepabdurohman.belajarthymeleafspring.service.impl;

import com.acepabdurohman.belajarthymeleafspring.dto.ProductAddRequest;
import com.acepabdurohman.belajarthymeleafspring.exception.DataIsEmptyException;
import com.acepabdurohman.belajarthymeleafspring.model.Product;
import com.acepabdurohman.belajarthymeleafspring.repository.ProductRepository;
import com.acepabdurohman.belajarthymeleafspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> products = productRepository.findAllProduct();
        if (products.isEmpty()){
            throw new DataIsEmptyException();
        }
        return products;
    }

    @Override
    public void addOrUpdateProduct(ProductAddRequest productAddRequest) {
        if (productAddRequest.getIdProduct() == null){
            Product product = new Product();
            product.setName(productAddRequest.getProductName());
            product.setPrice(new BigDecimal(productAddRequest.getProductPrice()));
            productRepository.save(product);
        } else {
            Product currentProduct = productRepository.findOne(productAddRequest.getIdProduct());
            currentProduct.setName(productAddRequest.getProductName());
            currentProduct.setPrice(new BigDecimal(productAddRequest.getProductPrice()));
            productRepository.save(currentProduct);
        }

    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }
}
