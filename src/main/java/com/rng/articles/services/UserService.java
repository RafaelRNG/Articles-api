package com.rng.articles.services;

import com.rng.articles.dto.UserDTO;
import com.rng.articles.dto.UserReturnDTO;
import com.rng.articles.entities.Article;
import com.rng.articles.entities.Review;
import com.rng.articles.entities.User;
import com.rng.articles.repositories.ArticleRepository;
import com.rng.articles.repositories.ReviewRepository;
import com.rng.articles.repositories.UserRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Page<User> pagination(Integer page, Integer linesPerPage, String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return userRepository.findAll(pageRequest);
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

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getUserContactRule(), userDTO.getUserRole(), userDTO.getUserAdmiredUsers());
    }

    public UserReturnDTO userReturnDTO(Long id){
        List<Article> articles = articleRepository.findByUserId(id);

        List<Review> reviews = reviewRepository.findByUserId(id);

        User user = userRepository.findById(id).get();

        return new UserReturnDTO(user.getId(), user.getName(), user.getUserContactRule(), user.getUserRole(), user.getUserAdmiredUsers(), articles,reviews);
    }
}