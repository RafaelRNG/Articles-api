package com.rng.articles.services;

import com.rng.articles.entities.User;
import com.rng.articles.repositories.UserRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found, ID: " + id));
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User update(Long id, User user){
        User userUpdate = userRepository.findById(id).get();
        user.setId(userUpdate.getId());
        userRepository.save(user);
        return user;
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}