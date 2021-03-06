package com.rng.articles.controllers;

import com.rng.articles.dto.UserDTO;
import com.rng.articles.dto.UserReturnDTO;
import com.rng.articles.entities.User;
import com.rng.articles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<User>> pagination(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name ="linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(name = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction){

        return ResponseEntity.ok(userService.pagination(page, linesPerPage, orderBy, direction));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<Page<User>> search(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(name = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction){

        return ResponseEntity.ok(userService.search(name, page, linesPerPage, direction, orderBy));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserReturnDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(userService.userReturnDTO(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        userService.save(user);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri()).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        userService.update(id, user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}