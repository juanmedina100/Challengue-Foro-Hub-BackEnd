package com.jimd.Security01.service.auth;

import com.jimd.Security01.persistencia.entities.login.UserEntity;
import com.jimd.Security01.persistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity agregarUsuario(UserEntity user){
        return userRepository.save(user);
    }
}
