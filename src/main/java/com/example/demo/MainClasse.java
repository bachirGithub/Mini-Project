package com.example.demo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import  com.example.demo.entities.*;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
public class MainClasse {
	private int count;
	public JSONArray utilisateursList;
	public MainClasse(int count) {
		count=count;
		utilisateursList=new JSONArray();
		this.genaration(count);
	}
	public static void main(String[] args) {
		new MainClasse(5);
	}
	public void genaration(int count){
    	for(int i=0;i<count-1;i++) {
    		JSONObject utilisateur = new JSONObject();
    		Faker faker = new Faker();
    		FakeValuesService fakeValuesService = new FakeValuesService(
    			    new Locale("en-GB"), new RandomService());
            utilisateur.put("firstName",faker.name().firstName());
            utilisateur.put("lastName",faker.name().lastName());
            utilisateur.put("birthDate", faker.date().birthday());		
            utilisateur.put("city", faker.address().city());
    	    utilisateur.put("country", faker.address().countryCode());
            utilisateur.put("avatar", faker.avatar().image());
    		utilisateur.put("company", faker.company().name());
    		utilisateur.put("jobPosition", faker.job().title());
    		utilisateur.put("mobile", faker.phoneNumber().phoneNumber());
    		utilisateur.put("username", faker.name().username());
            utilisateur.put("email", fakeValuesService.bothify("????##@gmail.com"));
            utilisateur.put("password", faker.internet().password(6,10));
    		utilisateur.put("role",faker.bothify("admin"));
    		utilisateursList.add(utilisateur);	
    	}
	}
 
}
