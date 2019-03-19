package com.acepabdurohman.belajarthymeleafspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductAddRequest {

    private Integer idProduct;

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @NotEmpty
    private String productPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productExpire;
}