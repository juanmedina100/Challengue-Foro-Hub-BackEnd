package com.jimd.Security01.service.auth;

import com.jimd.Security01.Config.utils.JwtUtils;
import com.jimd.Security01.controler.dtoAuth.AuthCreateUser;
import com.jimd.Security01.controler.dtoAuth.AuthLoginRequest;
import com.jimd.Security01.controler.dtoAuth.AuthResponse;
import com.jimd.Security01.persistencia.entities.login.RoleEntity;
import com.jimd.Security01.persistencia.entities.login.UserEntity;
import com.jimd.Security01.persistencia.repository.RoleRepositorio;
import com.jimd.Security01.persistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private RoleRepositorio roleRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

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

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();
        Authentication authentication = this.authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(username,"User loged",accessToken,true);
        return authResponse;
    }
    public Authentication authenticate(String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);
        if (userDetails==null){
            throw  new BadCredentialsException("Not Users");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw  new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
    }

    public AuthResponse creteUser(AuthCreateUser authCreateUser) throws IllegalAccessException {
        String username = authCreateUser.username();
        String password = authCreateUser.password();
        List<String> roleReques = authCreateUser.roleRequest().roleListName();

        Set<RoleEntity> roleEntitySet = roleRepositorio.findRoleEntityByReloEnumIn(roleReques).stream().collect(Collectors.toSet());
        if (roleEntitySet.isEmpty()){
            throw new IllegalAccessException("Role no existe");
        }
        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleEntitySet)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .redentialNoExperid(true)
                .build();
        UserEntity userCreate =  userRepository.save(userEntity);
        //Crear el token
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userCreate.getRoles().forEach(
                role->authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getReloEnum().name())))
        );

        userCreate.getRoles()
                .stream()
                .flatMap(role->role.getPermissionEntitySet().stream())
                .forEach(permission->authorities.add(new SimpleGrantedAuthority(permission.getName())));

//        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userCreate.getUsername(),userCreate.getPassword(),authorities);
        String accessToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(userCreate.getUsername(),"User Created",accessToken,true);
        return authResponse;
    }
}
