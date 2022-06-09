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
public class Conversion extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private UUID numeroFacture;
	private UUID client;
	private Date date;
	private long Montant;
	private long Valeur;
	private long Taux;
}
