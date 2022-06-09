package com.ids.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.Facture;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/factures
@RestController
@RequestMapping("/api/v1/factures")
@CrossOrigin("*")
@AllArgsConstructor
public class FactureControler extends AbstractCrudController<Facture, UUID> {

}