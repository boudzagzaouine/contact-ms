package com.ids.entity;

import java.util.Date;
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
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Where(clause = "deleted = false")
public class ArticleClient extends EntityUuid {
	private String design;
	private long poid;
	private double prix;
	private Date date;
	private UUID idClient;
	private UUID idFamilleArticle;
	private UUID idFournisseur;
}
