package com.baobab.personnel.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ABSTRACT_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	@Column(name = "USER_NAME", length = 150)
	private String username;

	@CreatedDate
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP")
	@JsonIgnore
	private LocalDateTime createDate;

	@LastModifiedDate
	@Column(name = "LAST_MODIFY_DATE", columnDefinition = "TIMESTAMP")
	@JsonIgnore
	private LocalDateTime lastModifyDate;
	
	/*
	private @ManyToOne @CreatedBy AbstractEntity createdBy;

	private @ManyToOne @LastModifiedBy AbstractEntity lastModifiedBy;

*/
}
