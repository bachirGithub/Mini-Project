package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Utilisateur;

public interface UtilRepo extends JpaRepository<Utilisateur,Long> {

	public Utilisateur findByUsername(String username);

}
