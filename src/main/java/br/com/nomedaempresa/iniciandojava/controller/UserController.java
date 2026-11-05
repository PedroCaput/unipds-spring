package br.com.nomedaempresa.iniciandojava.controller;

import br.com.nomedaempresa.iniciandojava.model.User;
import br.com.nomedaempresa.iniciandojava.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service){
        this.service = service;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@RequestBody Integer id){
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(201).body(service.addUser(user));
    }
}
