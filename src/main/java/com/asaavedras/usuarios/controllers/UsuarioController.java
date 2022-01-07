package com.asaavedras.usuarios.controllers;

import com.asaavedras.usuarios.models.request.UserCreateRequestDto;
import com.asaavedras.usuarios.models.responses.UserResponseDto;
import com.asaavedras.usuarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<?> createUser(@RequestBody @Valid UserCreateRequestDto user){
        UserResponseDto userCreateResponseDto = userService.createUser(user);
        return ResponseEntity.ok(userCreateResponseDto);
    }

    @GetMapping
    private ResponseEntity<?> getUsers(){
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userResponseDtos = userService.getUsers();
        return  ResponseEntity.ok(userResponseDtos);
    }

}
