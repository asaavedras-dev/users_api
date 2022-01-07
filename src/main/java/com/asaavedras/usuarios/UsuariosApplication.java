package com.asaavedras.usuarios;

import com.asaavedras.usuarios.entities.Phone;
import com.asaavedras.usuarios.entities.User;
import com.asaavedras.usuarios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class UsuariosApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		test();
	}

	public void test(){

	}

}
