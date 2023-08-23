package com.baobab.personnel.common.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.baobab.personnel.entities.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto extends AbstractRequest {

	private String name;
	
	private Date start;

	private LocalTime localTime;

	private LocalDate localDate;

	private LocalDateTime localDateTime;

	private Instant instantDate;

	public Utilisateur toEntity(UtilisateurDto utilisateurDto) {
		
		if(utilisateurDto == null) {
			
			return null;
		}
		
		return Utilisateur.builder().name(utilisateurDto.getName()).build();
	}

}
