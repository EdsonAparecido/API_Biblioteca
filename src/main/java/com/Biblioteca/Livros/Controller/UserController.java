package com.Biblioteca.Livros.Controller;

import com.Biblioteca.Livros.DTO.UsersCreateDTO;
import com.Biblioteca.Livros.DTO.UsersUpdateDTO;
import com.Biblioteca.Livros.Model.Users;
import com.Biblioteca.Livros.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Users")
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<Void> newUser(@Valid @RequestBody UsersCreateDTO usersCreateDTO){
        usersService.createUsers(usersCreateDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public Optional<Users> readUserById(@PathVariable Long id){
        return usersService.readUsersById(id);
    }
    @GetMapping()
    public List<Users> readUser(){
        return usersService.readUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@Valid @RequestBody UsersUpdateDTO usersUpdateDTO){
        usersService.updateUsers(id, usersUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUsers(id);
    }

}
