package com.ids.entity;

import java.sql.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Where;

import com.ids.data.entity.EntityUuid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder

@RequiredArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Where(clause = "deleted = false")
@Data
public class Avoir extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private Facture NumFacrture;
	private Client design;
	private Long Numero;
	private Date date;
	private long Montant;

}