package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.User.UserCreateDTO;
import com.Biblioteca.Livros.DTO.User.UserUpdateDTO;
import com.Biblioteca.Livros.Mapper.UserMapper;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.User;
import com.Biblioteca.Livros.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(UserCreateDTO userCreateDTO) {
        User user = UserMapper.DTOCreateToUser(userCreateDTO);
        userRepository.save(user);
    }

    public List<User> readUser(){
        return userRepository.findAll();
    }
    public Optional<User> readUserById(Long id){
        return userRepository.findById(id);
    }

    public void updateUser(Long id, UserUpdateDTO userUpdateDTO){
        User user = UserMapper.DTOUpdateToUser(userUpdateDTO);
        User idUser = userRepository.findById(id)
                .orElseThrow();

        User userUpdate = User.builder()
                .id(id)
                .name(hasText(user.getName()) ? user.getName() : idUser.getName())
                .email(hasText(user.getEmail()) ? user.getEmail() : idUser.getEmail())
                .numero(hasText(user.getNumero()) ? user.getNumero() : idUser.getNumero())
                .typeUser(idUser.getTypeUser())
                .build();

        userRepository.save(userUpdate);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> bookIsPresent(Long id){
        return userRepository.findByIdAndBookIsNull(id);
    }

    public void updateUserIdBook(Long id, Book book){
        User idUser = userRepository.findById(id)
                .orElseThrow();

        User userUpdate = User.builder()
                .id(id)
                .name(idUser.getName())
                .email(idUser.getEmail())
                .numero(idUser.getNumero())
                .typeUser(idUser.getTypeUser())
                .book(book)
                .build();

        userRepository.save(userUpdate);
    }

}
