package com.hoopdunk.api_hoopdunk.service;

import com.hoopdunk.api_hoopdunk.domain.User;
import com.hoopdunk.api_hoopdunk.dto.user.CreateUserDto;
import com.hoopdunk.api_hoopdunk.dto.user.UpdateUserDto;
import com.hoopdunk.api_hoopdunk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    //Spring acha automaticamente esse repository e ja lanca no construtor aq automaticamente
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //retornando id quando criar
    public Integer createUser(CreateUserDto createUserDto) {
        User usuario = new User(createUserDto);
        var userSaved =  userRepository.save(usuario);

        return userSaved.getId(); //retorna só id do cara que foi criado
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById (Integer userId, UpdateUserDto updateUserDto) {
        var userEntity = userRepository.findById(userId); //entidade User
        if(userEntity.isPresent()) { //se existir user
            var user = userEntity.get(); //ele pega o usuario e lança p essa variavel aqui

            user.setNome(updateUserDto.nome());
            user.setNomePerfil(updateUserDto.nomePerfil());
            user.setEmail(updateUserDto.email());
            user.setPosicao(updateUserDto.posicao());
            user.setNivel(updateUserDto.nivel());

            if(updateUserDto.senha() != null) {
                user.setSenha(updateUserDto.senha());
            }

            userRepository.save(user);
        }
    }

    public void deleteById(Integer userId) {
        var userExists = userRepository.existsById(userId); //boolean
        if(userExists) {
            userRepository.deleteById(userId);
        }
    }


}
