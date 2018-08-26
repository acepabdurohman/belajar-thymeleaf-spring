package com.acepabdurohman.belajarthymeleafspring.controller;

import com.acepabdurohman.belajarthymeleafspring.dto.ProductAddRequest;
import com.acepabdurohman.belajarthymeleafspring.model.Product;
import com.acepabdurohman.belajarthymeleafspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping("/page/type")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView showAddUpdateProduct(@RequestParam("form") String form,
                                       @RequestParam(value = "id", required = false) String id){
        ModelAndView modelAndView = new ModelAndView();
        if (form.equals("addProduct")){
            modelAndView.setViewName("add-product");
            return modelAndView;
        } else {
            Product currentProduct = productService.findById(Integer.parseInt(id));
            modelAndView.addObject("product", currentProduct);
            modelAndView.setViewName("edit-product");
            return modelAndView;
        }
    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addOrUpdateProduct(@RequestBody @Valid ProductAddRequest request){
        productService.addOrUpdateProduct(request);
        try{
            URI location = new URI("http://localhost:1111/products/page");
            return ResponseEntity.created(location).build();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteProductById(@RequestBody String id){
        productService.delete(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }
}