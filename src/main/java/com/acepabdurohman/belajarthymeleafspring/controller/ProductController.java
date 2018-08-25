package com.acepabdurohman.belajarthymeleafspring.controller;

import com.acepabdurohman.belajarthymeleafspring.model.Product;
import com.acepabdurohman.belajarthymeleafspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/page")
    public String showProducts(){
        return "products";
    }
}