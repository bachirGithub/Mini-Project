package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UpLoadUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	}
	public static void lectureFichier() {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("utilisateurs.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray utilisateursList = (JSONArray) obj;
            System.out.println(utilisateursList);
             
            //Iterate over employee array
            //employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private static void parseUtilisateurObject(JSONObject utilisateur) 
    {
        //Get Utilisateur object within list
        JSONObject utilisateurObject = (JSONObject) utilisateur.get("employee");
         
        //Get employee first name
        String firstName = (String) utilisateurObject.get("firstName");    
        System.out.println(firstName);
         
        //Get employee last name
        String lastName = (String) utilisateurObject.get("lastName");  
        System.out.println(lastName);
         
    }

}
