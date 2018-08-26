package com.acepabdurohman.belajarthymeleafspring.repository;

import com.acepabdurohman.belajarthymeleafspring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}