package com.vai.user.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vai.user.userDTO.User;
import com.vai.user.userRepository.userRepo;

@Service
public class customUserDetailsService  {

    @Autowired
    userRepo urepo;

    
    public User loadUserByUsername(String email)   {
        User user= urepo.findByEmail(email);
    return user;
        
    }

}
