package com.asaavedras.usuarios.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    private Date created;

    private Date modified;

    private Date last_login;

    private String token;

    private boolean active;
}
