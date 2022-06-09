package com.ids.entity;

import java.sql.Date;
import java.util.UUID;

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
public class Journal extends EntityUuid {
	private static final long serialVersionUID = 1L;
	public UUID numeroFacture;
	private UUID client;
	private Long Entree;
	private Long Sortie;
	private Date date;
	private String Type;
}
