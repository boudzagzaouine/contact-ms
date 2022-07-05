
package com.ids.entity;

import java.math.BigDecimal;
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
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Where(clause = "deleted = false")
public class RepasNutritionJournalier extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private Date heureRepas;
	private BigDecimal ancRecommande;
	private BigDecimal ancCalcule;
	private Long quantité;
}