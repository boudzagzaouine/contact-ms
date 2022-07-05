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
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Where(clause = "deleted = false")
public class Langue extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private String designation;
}
