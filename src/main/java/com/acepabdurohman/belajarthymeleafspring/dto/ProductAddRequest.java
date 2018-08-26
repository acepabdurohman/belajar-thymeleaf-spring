package com.acepabdurohman.belajarthymeleafspring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class ProductAddRequest {

    private Integer idProduct;

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @NotEmpty
    private String productPrice;
}
