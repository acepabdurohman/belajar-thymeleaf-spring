package com.acepabdurohman.belajarthymeleafspring.service.impl;

import com.acepabdurohman.belajarthymeleafspring.model.User;
import com.acepabdurohman.belajarthymeleafspring.repository.UserRepository;
import com.acepabdurohman.belajarthymeleafspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        detailsChecker.check(user);
        return user;
    }
}
