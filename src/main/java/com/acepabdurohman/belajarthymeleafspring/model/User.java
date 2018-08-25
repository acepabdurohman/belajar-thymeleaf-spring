package com.acepabdurohman.belajarthymeleafspring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "t_user_authorities",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")}
    )
    private List<Authority> authorities;
}
