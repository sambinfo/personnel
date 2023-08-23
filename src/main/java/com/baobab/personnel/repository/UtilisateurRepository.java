package com.baobab.personnel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baobab.personnel.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
