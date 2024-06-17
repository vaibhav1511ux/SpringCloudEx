package com.vai.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vai.user.userDTO.LoginRequest;
import com.vai.user.userDTO.User;
import com.vai.user.userRepository.userRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")  // Your frontend URL
 public class userController {

    @Autowired
    userRepo userrepo;

    @GetMapping
    public List<User>getUser(){
        return userrepo.findAll();

    }

    @PostMapping("/register")
    public ResponseEntity<String>  saveUser(@RequestBody User user){
         User u1=userrepo.save(user);
         if(u1==null){
            return ResponseEntity.status(404).build();
         }else{
            return ResponseEntity.ok("user save succefully : "+u1.getName());
         }
    }

    @GetMapping("/email/{email}")
    public String findByEmail(@PathVariable String email){
        return userrepo.findByEmail(email).getName();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userrepo.deleteById(id);
        return ResponseEntity.ok("user deleted succefully");
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> LoginUser(@RequestBody LoginRequest loginRequest){
        User u1=userrepo.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if(u1==null){
            return ResponseEntity.status(404).build();
        }else{
            return ResponseEntity.status(200).body(u1);
        }
    }

    @PostMapping("/logout")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("Logout successful");
    }

}