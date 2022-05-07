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
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Where(clause = "deleted = false")
public class Client extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private String design;
	private String concat;
	private String image;
	private String email;
	private String tel;
	private String device;
	private String adrLiv;
	private String incoterm;
	private String paymentChoice;
	private String adrFact;
	private String bank;
	private String rib;
	private String swift;
}
