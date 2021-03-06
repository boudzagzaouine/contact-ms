package com.ids.entity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Avoir extends EntityUuid {

	private static final long serialVersionUID = 1L;
	private Date date;
	private double montant;
	private UUID numeroFacture;
	private UUID client;
	private double numeroAvoir;

	@OneToMany
	private List<Client> clients;

}
