package com.asaavedras.usuarios.models.request;

import com.asaavedras.usuarios.models.responses.PhoneResponseDto;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class UserCreateRequestDto {

    private UUID id;

    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^(?=(?:.*\\d){2})(?=(?:.*[A-Z]){1})(?=(?:.*[a-z]){1})\\S{8,}$", message = "Password debe tener una" +
            "mayúscula, letras minúsculas, y dos numeros")
    private String password;

    private List<PhoneResponseDto> phones;

    private Date created;

    private Date modified;

    private Date last_login;

    private boolean active;
}
