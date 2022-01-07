package com.asaavedras.usuarios.services;

import com.asaavedras.usuarios.models.request.UserCreateRequestDto;
import com.asaavedras.usuarios.models.responses.UserResponseDto;

import java.util.List;

public interface UserService {

    public UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto);

    public List<UserResponseDto> getUsers();
}
