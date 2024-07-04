package com.jimd.Security01.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/secure/hello")
    public ResponseEntity<String> helloWork(){
        return ResponseEntity.ok().body("Hello Work sin seguridad");
    }

    @GetMapping("/auth/hello-a")
    public ResponseEntity<String> helloSecure(){
        return ResponseEntity.ok().body("Esta Web debe ser autenticada ...Seguro");
    }
    @PostMapping("/auth/agregar")
    public ResponseEntity<String> agregar(){
        return ResponseEntity.ok().body("Haz agregado");
    }
}
