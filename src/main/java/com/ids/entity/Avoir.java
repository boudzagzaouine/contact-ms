package com.ids.entity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long numeroAvoir;

	@OneToMany
	private List<Client> clients;
	@OneToMany
	private List<ArticleCommande> article;
}
