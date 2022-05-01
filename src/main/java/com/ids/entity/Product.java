package com.ids.entity;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import com.ids.data.entity.AuditableEntityId;

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
public class Product extends AuditableEntityId<UUID> {
	private static final long serialVersionUID = 1L;

	private String name;
	// pour les nombres réels, il faut utiliser BigDecimal
	private BigDecimal price;
	@ToString.Exclude
	@ManyToOne
	private Unit unit;
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Map<String, Object> configuration;
}