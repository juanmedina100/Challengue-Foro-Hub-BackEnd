package com.jimd.Security01.service;

import com.jimd.Security01.persistencia.UserEntity;
import com.jimd.Security01.persistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario "+username+ " no existe"));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role-> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getReloEnum().name()))));
        userEntity.getRoles().stream()
                .flatMap(role->role.getPermissionEntitySet().stream())
                        .forEach(permission-> authorities.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isRedentialNoExperid(),
                userEntity.isAccountNoLocked(),
                authorities);
    }
}
