package com.baobab.personnel.contoller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baobab.personnel.contoller.ressources.UCCreateUserRessource;
import com.baobab.personnel.contoller.ressources.UCGetUserRessource;
import com.baobab.personnel.repository.UtilisateurRepository;
import com.baobab.personnel.service.CommonService;

@RestController
@RequestMapping(path = "user")
public class UtilisateurController {
	Logger logger = LoggerFactory.getLogger(com.baobab.personnel.contoller.UtilisateurController.class);

	UtilisateurRepository utilisateurRepository;

	CommonService commonService;
	
	public UtilisateurController() {
		super();
	}

	public UtilisateurController(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public UtilisateurController(CommonService commonService) {
		this.commonService = commonService;
	}

	@GetMapping(path="getUsers", 
			produces = {APPLICATION_JSON_VALUE})
	ResponseEntity getUsers(){
		return UCGetUserRessource.Service(this.utilisateurRepository);
	}
	
	@PostMapping(path = "createUser", 
			consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE}, 
			produces = {APPLICATION_JSON_VALUE})
	ResponseEntity createUser(){
		return UCCreateUserRessource.Service(this.commonService);
	}

}
