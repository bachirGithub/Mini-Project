package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UtilRepo;
import com.example.demo.entities.Utilisateur;

@Service
public class UtilService implements UserDetailsService {
private UtilRepo utilRepo;
private PasswordEncoder passwordEncoder;

public UtilService() {
	// TODO Auto-generated constructor stub
}
@Autowired
public UtilService(UtilRepo utilRepo) {
	this.utilRepo = utilRepo;
}

public void ajouterUtil(Utilisateur utilisateur) {
	utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
	utilRepo.save(utilisateur);
}
public void ajouterUtils(List<Utilisateur> utilisateurs) {
	utilRepo.saveAll(utilisateurs);
}
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Utilisateur utilisateur=utilRepo.findByUsername(username);
	if(utilisateur==null) {
		throw new UsernameNotFoundException("User not found");
	} else {
		System.out.println("user found"+username);
	}
	Collection<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
	authorities.add(new SimpleGrantedAuthority(utilisateur.getRole()));
	return new org.springframework.security.core.userdetails.User(utilisateur.getUsername(),
			utilisateur.getPassword(),authorities);
}

}
