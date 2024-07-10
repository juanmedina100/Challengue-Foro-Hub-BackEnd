package com.jimd.Security01.controler;

import com.jimd.Security01.service.ResponService;
import com.jimd.Security01.service.dtoRespon.DatosAgregarResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/response")
@SecurityRequirement(name = "bearer-key")
public class ResponController {

    @Autowired
    private ResponService responService;

    @PostMapping("/response")
    public ResponseEntity<DatosAgregarResponse> addResponse(@Valid @RequestBody DatosAgregarResponse datos){
        return new ResponseEntity<>(responService.addResponse(datos), HttpStatus.CREATED);
    }
}
