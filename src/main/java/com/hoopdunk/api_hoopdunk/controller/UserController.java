package com.hoopdunk.api_hoopdunk.controller;

import com.hoopdunk.api_hoopdunk.domain.User;
import com.hoopdunk.api_hoopdunk.dto.CreateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto body) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return null;
    }

}
