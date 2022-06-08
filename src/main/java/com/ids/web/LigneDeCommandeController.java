package com.ids.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.LigneDeCommande;
import com.ids.repository.LigneDeCommandeRepository;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/lignesDecommand
@RestController
@RequestMapping("/api/v1/lignesDecommand")
@CrossOrigin("*")
@AllArgsConstructor
public class LigneDeCommandeController extends AbstractCrudController<LigneDeCommande, UUID> {

	private LigneDeCommandeRepository repository;

	@GetMapping("/idcommandefournisseur/{idCommandeFournisseur}")
	public Map<String, List<LigneDeCommande>> ByIdCommandeFournisseur(@PathVariable UUID idCommandeFournisseur) {
		return new HashMap<String, List<LigneDeCommande>>() {
			{
				put("content", repository.findByIdCommandeFournisseur(idCommandeFournisseur));
			}
		};
	}

	@GetMapping("/idcommandefournisseur/{idCommandeFournisseur}")
	public Map<String, List<LigneDeCommande>> ByIdCommandeFournisseur2(@PathVariable UUID idCommandeFournisseur) {
		return new HashMap<String, List<LigneDeCommande>>() {
			{
				put("content", repository.findByIdCommandeFournisseur(idCommandeFournisseur));
			}
		};
	}

	@GetMapping("/idmatierepremiere/{idMatierePremiere}")
	public Map<String, List<LigneDeCommande>> ByIdMatierePremiere(@PathVariable UUID idMatierePremiere) {
		return new HashMap<String, List<LigneDeCommande>>() {
			{
				put("content", repository.findByIdMatierePremiere(idMatierePremiere));
			}
		};
	}

	@GetMapping("/parent/{idMatierePremiere}")
	public Map<String, List<LigneDeCommande>> ByIdMatierePremiere2(@PathVariable UUID idMatierePremiere) {
		return new HashMap<String, List<LigneDeCommande>>() {
			{
				put("content", repository.findByIdMatierePremiere(idMatierePremiere));
			}
		};
	}
}
