package com.vai.user.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vai.user.userDTO.User;

public interface userRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
