package com.asaavedras.usuarios.repositories;


import com.asaavedras.usuarios.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
