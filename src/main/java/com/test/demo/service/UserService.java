package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.entity.User;
import com.test.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;
 
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
