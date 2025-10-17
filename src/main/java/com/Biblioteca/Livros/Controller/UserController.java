package com.Biblioteca.Livros.Controller;

import com.Biblioteca.Livros.DTO.User.UserCreateDTO;
import com.Biblioteca.Livros.DTO.User.UserUpdateDTO;
import com.Biblioteca.Livros.Model.User;
import com.Biblioteca.Livros.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Home/User")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> newUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<User> readUser(){
        return userService.readUser();
    }
    @GetMapping("/{id}")
    public Optional<User> readUserById(@PathVariable Long id){
        return userService.readUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@Valid @RequestBody UserUpdateDTO userUpdateDTO){
        userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
