package com.ids.entity;

import java.sql.Date;
import java.util.UUID;

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
@ToString(callSuper = true)
@Entity
@Where(clause = "deleted = false")
@Setter
@Getter
public class Facture extends EntityUuid {
	private static final long serialVersionUID = 1L;
	public double NumFacture;
	private UUID client;
	private double NumColisage;
	private Date date;
	private double Montant;
	private double Reduction;
	private double Tva;
	private double Total;
	private String payement;

}
