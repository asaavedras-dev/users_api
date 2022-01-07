package com.asaavedras.usuarios.models.responses;

import lombok.Data;

@Data
public class PhoneResponseDto {

    private int number;
    private int cityCode;
    private int countryCode;

}
