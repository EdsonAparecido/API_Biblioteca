package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.UsersCreateDTO;
import com.Biblioteca.Livros.DTO.UsersUpdateDTO;
import com.Biblioteca.Livros.Mapper.UsersMapper;
import com.Biblioteca.Livros.Model.Users;
import com.Biblioteca.Livros.Repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void createUsers(UsersCreateDTO usersCreateDTO) {
        Users users = UsersMapper.DTOCreateToModel(usersCreateDTO);
        usersRepository.save(users);
    }

    public List<Users> readUsers(){
        return usersRepository.findAll();
    }
    public Optional<Users> readUsersById(Long id){
        return usersRepository.findById(id);
    }

    public void updateUsers(Long id, UsersUpdateDTO usersUpdateDTO){
        Users users = UsersMapper.DTOUpdateToModel(usersUpdateDTO);
        Users idUser = usersRepository.findById(id)
                .orElseThrow();

        Users userUpdate = Users.builder()
                .id(id)
                .name(hasText(users.getName()) ? users.getName() : idUser.getName())
                .email(hasText(users.getEmail()) ? users.getEmail() : idUser.getEmail())
                .numero(hasText(users.getNumero()) ? users.getNumero() : idUser.getNumero())
                .typeUsers(idUser.getTypeUsers())
                .build();

        usersRepository.save(userUpdate);
    }

    public void deleteUsers(Long id){
        usersRepository.deleteById(id);
    }
}
