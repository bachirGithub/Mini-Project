package com.example.demo.web;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MainClasse;
import com.example.demo.entities.Utilisateur;


@RestController
public class UtilisateurControleur {
    @RequestMapping("/api/users/generate")
	public List<Object> index(@RequestParam(name="count") int count,Model modele) {
    	MainClasse mc=new MainClasse(count);
    	JSONArray utilisateursList=mc.utilisateursList;
    	try (FileWriter file = new FileWriter("utilisateurs.json")) {
            file.write(utilisateursList.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return new ArrayList<>();
	}
}
