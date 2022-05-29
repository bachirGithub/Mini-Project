package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.services.UtilService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entities.*;
@SpringBootApplication
public class MiniProjectApplication implements CommandLineRunner {
    @Autowired
	private UtilService utilService;
	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// read JSON and load json
					ObjectMapper mapper = new ObjectMapper();
					TypeReference<List<Utilisateur>> typeReference = new TypeReference<List<Utilisateur>>(){};
					InputStream inputStream = TypeReference.class.getResourceAsStream("/json/utilisateurs.json");
					try {
						List<Utilisateur> utilisateurs = mapper.readValue(inputStream,typeReference);
						//utilService.ajouterUtils(utilisateurs);
						//System.out.println(utilisateurs);
						utilisateurs.forEach(u->utilService.ajouterUtil(u));
					} catch (IOException e){
						System.out.println("Unable to save users: " + e.getMessage());
					}
	}
	

}
