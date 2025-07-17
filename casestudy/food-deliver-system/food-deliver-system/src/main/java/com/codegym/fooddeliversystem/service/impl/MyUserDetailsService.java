package com.codegym.fooddeliversystem.service.impl;

import com.codegym.fooddeliversystem.model.User;
import com.codegym.fooddeliversystem.model.UserPrincipal;
import com.codegym.fooddeliversystem.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            System.out.println("User not found...");
            throw new UsernameNotFoundException("user not found...");
        }
        return UserPrincipal.build(user);
    }
}
