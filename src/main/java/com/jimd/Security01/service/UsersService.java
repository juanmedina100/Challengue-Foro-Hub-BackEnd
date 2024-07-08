package com.jimd.Security01.service;

import com.jimd.Security01.persistencia.UserEntity;
import com.jimd.Security01.persistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity agregarUsuario(UserEntity user){
        return userRepository.save(user);
    }
}
