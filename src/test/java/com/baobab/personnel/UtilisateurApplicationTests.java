package com.baobab.personnel;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baobab.personnel.entities.Utilisateur;
import com.baobab.personnel.repository.UtilisateurRepository;

@SpringBootTest
public class UtilisateurApplicationTests {

	Logger logger = LoggerFactory.getLogger(com.baobab.personnel.UtilisateurApplicationTests.class);

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	public void creerUtilisateur() {

		Utilisateur utilisateur = new Utilisateur("Wade");

		utilisateurRepository.save(utilisateur);

	}

	@Test
	public void rechercherUtilisateur() {

		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findById(Long.valueOf(1));

		Utilisateur utilisateur = optUtilisateur.get();

		this.logger.info("### --- --- - rechercherUtilisateur : "+utilisateur.toString());

	} 


}
