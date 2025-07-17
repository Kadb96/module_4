package com.codegym.fooddeliversystem.service.impl;

import com.codegym.fooddeliversystem.model.User;
import com.codegym.fooddeliversystem.repository.IUserRepository;
import com.codegym.fooddeliversystem.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICustomerService customerService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(User user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated())
            return "";
        return "fail";
    }

//    public void save(UserDto userDto) {
//        User user = new User();
//        user.setUsername(userDto.getUsername());
//        Role role = roleService.findById(userDto.getRoleId()).get();
//        user.setRoles(Set.of(role));
//        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//
//        User newUser = userRepository.findUserByUsername(userDto.getUsername());
//
//        Customer customer = new Customer();
//        customer.setName(userDto.getName());
//        customer.setEmail(userDto.getEmail());
//        customer.setPhone(userDto.getPhone());
//        customer.setAddress(userDto.getAddress());
//        customer.setUser(newUser);
//
//        customerService.save(customer);
//    }
//
//    public boolean checkPassword(String username, String password) {
//        User user = userRepository.findUserByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return true;
//        }
//        return false;
//    }
//
//    public void delete(Long id) {
//        userRepository.deleteById(id);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepository.findUserByUsername(username);
//        if (user != null) {
//            return UserPrinciple.build(user);
//        }
//        return null;
//    }

}
