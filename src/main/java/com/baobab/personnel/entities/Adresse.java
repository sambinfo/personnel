package com.baobab.personnel.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Embeddable
public class Adresse implements Serializable {

	private  boolean isNull = true ;

	@Column(name = "NAME", length = 50)
	private String name;

	public  static Adresse ADRESSE_NULL =  new Adresse() ;

	public  static Adresse getAdresse(Adresse adresse) {
		if (adresse == null || adresse.isNull) {
			return null ;
		}  else {
			return adresse ;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adresse() {
		super();
	}
	
}
