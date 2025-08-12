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
    public Long createUser(CreateUserDto createUserDto) {
        User usuario = new User(createUserDto);

        if(userRepository.findByNomePerfil(usuario.getNomePerfil()).isPresent()) {
            throw new RuntimeException("Este nome de perfil já está em uso");
        } else if(userRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Este email já está em uso!");
        } else {
            var userSaved =  userRepository.save(usuario);

            return userSaved.getId(); //retorna só id do cara que foi criado
        }
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById (Long userId, UpdateUserDto updateUserDto) {
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

    public void deleteById(Long userId) {
        var userExists = userRepository.existsById(userId); //boolean
        if(userExists) {
            userRepository.deleteById(userId);
        }
    }


}
