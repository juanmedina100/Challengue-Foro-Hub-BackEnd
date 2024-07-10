package com.jimd.Security01.controler;

import com.jimd.Security01.controler.dtoAuth.AuthCreateUser;
import com.jimd.Security01.controler.dtoAuth.AuthLoginRequest;
import com.jimd.Security01.controler.dtoAuth.AuthResponse;
import com.jimd.Security01.persistencia.entities.login.UserEntity;
import com.jimd.Security01.service.auth.UserDetailServiceImpl;
import com.jimd.Security01.service.auth.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatorController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/auth/singup")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUser authCreateUser) throws IllegalAccessException {
        return new ResponseEntity<>(this.userDetailService.creteUser(authCreateUser),HttpStatus.CREATED);
    }
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest authLoginRequest){
        return new ResponseEntity<>(this.userDetailService.loginUser(authLoginRequest), HttpStatus.OK);
    }

//    @GetMapping("/auth/hello")
//    public ResponseEntity<String> helloWork(){
//        return ResponseEntity.ok().body("Hello Work sin seguridad");
//    }
//
//    @GetMapping("/auth/hello-a")
//    public ResponseEntity<String> helloSecure(){
//        return ResponseEntity.ok().body("Esta Web debe ser autenticada ...Seguro ADMIN");
//    }
//    @GetMapping("/auth/hello-b")
//    public ResponseEntity<String> helloSecureb(){
//        return ResponseEntity.ok().body("Esta Web debe ser autenticada ...Seguro INVITADO");
//    }
//    @GetMapping("/auth/hello-v")
//    public ResponseEntity<String> helloSecurec(){
//        return ResponseEntity.ok().body("Esta Web debe ser autenticada ...Seguro SOLO AUTENTICADO");
//    }
//    @PostMapping("/auth/user")
//    public ResponseEntity<UserEntity> agregar(@RequestBody UserEntity userEntity){
//        return ResponseEntity.ok().body(userEntity);
////        return ResponseEntity.ok().body("Haz agregado");
//    }
}
