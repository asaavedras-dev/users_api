package com.asaavedras.usuarios.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="phones")
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int number;

    private int cityCode;

    private int countryCode;

    @ManyToOne
    @JoinColumn(name = "FK_USER", nullable = false, updatable = false)
    private User user;
}
