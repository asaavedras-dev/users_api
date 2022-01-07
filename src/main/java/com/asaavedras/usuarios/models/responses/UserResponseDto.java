package com.asaavedras.usuarios.models.responses;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class UserResponseDto {
    private UUID id;

    private String name;

    private String email;

    private List<PhoneResponseDto> phones;

    private Date created;

    private Date modified;

    private Date last_login;

    private String token;

    private boolean active;
}
