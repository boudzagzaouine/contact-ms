package com.ids.entity;

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
@Setter
@Getter
@ToString(callSuper = true)
@Entity
@Where(clause = "deleted = false")
public class articleFacture extends EntityUuid {

	private static final long serialVersionUID = 1L;
	private double codeArticle;
	private double prixUnitaire;
	private double quantité;
	private String designation;
}
