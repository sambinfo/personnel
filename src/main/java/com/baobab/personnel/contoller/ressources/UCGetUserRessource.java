package com.baobab.personnel.contoller.ressources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.baobab.personnel.entities.Utilisateur;
import com.baobab.personnel.repository.UtilisateurRepository;

public class UCGetUserRessource {

	final static Logger logger = LoggerFactory.getLogger(com.baobab.personnel.contoller.ressources.UCGetUserRessource.class);

	public static ResponseEntity Service(UtilisateurRepository utilisateurRepository) {
		logger.info("### --- --- - getUsers : ");

		List<Utilisateur> listtsers = utilisateurRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(listtsers);		
	}
	
}
