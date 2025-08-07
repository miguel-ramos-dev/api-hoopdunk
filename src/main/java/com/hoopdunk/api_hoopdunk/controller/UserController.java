package com.hoopdunk.api_hoopdunk.controller;

import com.hoopdunk.api_hoopdunk.domain.User;
import com.hoopdunk.api_hoopdunk.dto.user.CreateUserDto;
import com.hoopdunk.api_hoopdunk.dto.user.UpdateUserDto;
import com.hoopdunk.api_hoopdunk.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;

    //Spring acha automaticamente esse repository e ja lanca no construtor aq automaticamente
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> listUser() {
        var users = userService.listUsers();
        return ResponseEntity.ok(users); //retornar ResponseEntity
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) {
        var user = userService.getUserById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok(user.get()); //.get retorna os dados do cara no corpo da requisição
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDto data) {
        var userId = userService.createUser(data);
//        return ResponseEntity.created(URI.create("/usuarios/" + userId.toString())).build();
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserDto data) {
        userService.updateUserById(id, data);
        return ResponseEntity.noContent().build(); //tipo, update, foi, n precisa retornar nenhum user

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletByid(@PathVariable("userId") Long id) {//boa pratica retornar nada
        userService.deleteById(id);
        return ResponseEntity.noContent().build(); //boa pratica esse noContent
    }
}
