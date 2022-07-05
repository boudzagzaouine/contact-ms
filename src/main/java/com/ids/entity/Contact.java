package com.ids.entity;

import java.sql.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Where;

import com.ids.data.entity.EntityUuid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Where(clause = "deleted = false")
public class Contact extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private String nom;
	private String address;
	private String ville;
	private String telephone;
	private String sexe;
	private Date dateNaisance;
	private Double taille;

}
