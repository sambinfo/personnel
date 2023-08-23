package com.baobab.personnel.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "UTILISATEUR")
@NamedQueries({
	@NamedQuery(name = "Utilisateur.find", query = "SELECT obj FROM Utilisateur obj WHERE obj.name = :name"),
	@NamedQuery(name = "Utilisateur.finds", query = "SELECT obj FROM Utilisateur obj WHERE obj.name = :name ORDER BY obj.start DESC")

})
public class Utilisateur extends AbstractEntity{
	@Column(name = "NAME", length = 20)
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "START")
	private Date start;

	@Column(name = "LOCAL_TIME", columnDefinition = "TIME")
	private LocalTime localTime;

	@Column(name = "LOCAL_DATE", columnDefinition = "DATE")
	private LocalDate localDate;

	@Column(name = "LOCAL_DATE_TIME", columnDefinition = "TIMESTAMP")
	private LocalDateTime localDateTime;

	@Column(name = "INSTANT_DATE")
	private Instant instantDate;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
				name="isNull", 
				column=@Column(name="ADRESSE_COURANTE_ISNULL")),
		@AttributeOverride(
				name="name",    
				column=@Column(name="ADRESSE_COURANTE_NAME"))
	})
	/*@AssociationOverrides({
		@AssociationOverride(
				name="commune", 
				joinColumns=@JoinColumn(name="ADRESSE_COURANTE_COMMUNE_ID"))
	})*/
	private Adresse adresseCourante ;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(
				name="isNull", 
				column=@Column(name="ADRESSE_NAISSANCE_COURANTE_ISNULL")),
		@AttributeOverride(
				name="name",    
				column=@Column(name="ADRESSE_NAISSANCE_COURANTE_RUE"))
	})
	/*@AssociationOverrides({
		@AssociationOverride(
				name="commune", 
				joinColumns=@JoinColumn(name="ADRESSE_NAISSANCE_COMMUNE_ID"))
	})*/
	private Adresse adresseDeNaissance ;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Instant getInstantDate() {
		return instantDate;
	}
	public void setInstantDate(Instant instantDate) {
		this.instantDate = instantDate;
	}

	public Adresse getAdresseCourante() {
		return adresseCourante;
	}
	public void setAdresseCourante(Adresse adresseCourante) {
		this.adresseCourante = adresseCourante;
	}
	public Adresse getAdresseDeNaissance() {
		return adresseDeNaissance;
	}
	public void setAdresseDeNaissance(Adresse adresseDeNaissance) {
		this.adresseDeNaissance = adresseDeNaissance;
	}
	@Override
	public String toString() {
		return "Utilisateur [name=" + name + ", start=" + start + ", localTime=" + localTime + ", localDate="
				+ localDate + ", localDateTime=" + localDateTime + ", instantDate=" + instantDate + ", adresseCourante="
				+ adresseCourante + ", adresseDeNaissance=" + adresseDeNaissance + ", getName()=" + getName()
				+ ", getStart()=" + getStart() + ", getLocalTime()=" + getLocalTime() + ", getLocalDate()="
				+ getLocalDate() + ", getLocalDateTime()=" + getLocalDateTime() + ", getInstantDate()="
				+ getInstantDate() + ", getAdresseCourante()=" + getAdresseCourante() + ", getAdresseDeNaissance()="
				+ getAdresseDeNaissance() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

	public Utilisateur(String name) {
		super();
		this.name = name;
		this.start = new Date();
	}

	public Utilisateur() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresseCourante, adresseDeNaissance, instantDate, localDate, localDateTime, localTime, name,
				start);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(adresseCourante, other.adresseCourante)
				&& Objects.equals(adresseDeNaissance, other.adresseDeNaissance)
				&& Objects.equals(instantDate, other.instantDate) && Objects.equals(localDate, other.localDate)
				&& Objects.equals(localDateTime, other.localDateTime) && Objects.equals(localTime, other.localTime)
				&& Objects.equals(name, other.name) && Objects.equals(start, other.start);
	}

}
