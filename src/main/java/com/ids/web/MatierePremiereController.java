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
import com.ids.entity.MatierePremiere;
import com.ids.repository.MatierePremiereRepository;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/matieresPremiere
@RequestMapping("/api/v1/matieresPremiere")
@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MatierePremiereController extends AbstractCrudController<MatierePremiere, UUID> {
	private MatierePremiereRepository repository;

	@GetMapping("/idfournisseurs/{idFournisseur}")
	public Map<String, List<MatierePremiere>> ByIdFournisseur(@PathVariable UUID idFournisseur) {
		return new HashMap<String, List<MatierePremiere>>() {
			{
				put("content", repository.findByIdFournisseur(idFournisseur));
			}
		};
	}

	@GetMapping("/parent/{idFournisseur}")
	public Map<String, List<MatierePremiere>> ByIdFournisseur2(@PathVariable UUID idFournisseur) {
		return new HashMap<String, List<MatierePremiere>>() {
			{
				put("content", repository.findByIdFournisseur(idFournisseur));
			}
		};
	}
	/*
	 * @PostMapping("/post") public void test(@RequestBody MatierePremiere m) { for
	 * (int i = 0; i < 10; i++) { System.out.println("salamo alaykom matiere = "+m);
	 * }
	 * System.out.println("--------------------------------------------------------"
	 * );
	 * System.out.println("--------------------------------------------------------"
	 * );
	 * System.out.println("--------------------------------------------------------"
	 * );
	 * 
	 * }
	 */
}
