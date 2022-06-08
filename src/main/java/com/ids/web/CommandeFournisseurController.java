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
import com.ids.entity.CommandeFournisseur;
import com.ids.repository.CommandeFournisseurRepository;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/commandeFournisseurs
@RestController
@RequestMapping("/api/v1/commandeFournisseurs")
@CrossOrigin("*")
@AllArgsConstructor
public class CommandeFournisseurController extends AbstractCrudController<CommandeFournisseur, UUID> {
	private CommandeFournisseurRepository repository;

	@GetMapping("/idfournisseurs/{idFournisseur}")
	public Map<String, List<CommandeFournisseur>> ByIdFournisseur(@PathVariable UUID idFournisseur) {
		return new HashMap<String, List<CommandeFournisseur>>() {
			{
				put("content", repository.findByIdFournisseur(idFournisseur));
			}
		};
	}

	@GetMapping("/parent/{idFournisseur}")
	public Map<String, List<CommandeFournisseur>> ByIdFournisseur2(@PathVariable UUID idFournisseur) {
		return new HashMap<String, List<CommandeFournisseur>>() {
			{
				put("content", repository.findByIdFournisseur(idFournisseur));
			}
		};
	}
}
