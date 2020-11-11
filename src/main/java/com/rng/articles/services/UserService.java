package com.rng.articles.services;

import com.rng.articles.entities.User;
import com.rng.articles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).get();
    }
}