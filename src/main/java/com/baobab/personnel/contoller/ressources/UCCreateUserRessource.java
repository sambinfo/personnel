package com.baobab.personnel.contoller.ressources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.baobab.personnel.entities.Utilisateur;
import com.baobab.personnel.service.CommonService;

public class UCCreateUserRessource {

	final static Logger logger = LoggerFactory.getLogger(com.baobab.personnel.contoller.ressources.UCCreateUserRessource.class);

	public static ResponseEntity Service(CommonService commonService) {
		logger.info("### --- --- - createUser : ");

		String name = "wade";

		String[] parameters = { "name" };
		Object[] data = { name };
		List<Utilisateur> listUsers =  (List<Utilisateur>) commonService.executeNamedQueryList(Utilisateur.class, "Utilisateur.find", parameters, data).stream().map(user -> new Utilisateur(user.getName()));

		return ResponseEntity.status(HttpStatus.OK).body(listUsers);		
	}
	
}
