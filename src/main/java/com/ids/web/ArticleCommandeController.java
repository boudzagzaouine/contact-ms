package com.ids.web;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.ArticleCommande;
import com.ids.repository.ArticleCommandeRepository;
import com.ids.service.ArticleCommandeService;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/ArticleCommandes
@RestController
@RequestMapping("/api/v1/articlecommandes")
@CrossOrigin("*")
@AllArgsConstructor
public class ArticleCommandeController extends AbstractCrudController<ArticleCommande, UUID> {
	private ArticleCommandeRepository repository;
	private ArticleCommandeService service;

	@GetMapping("/idcom/{idCommande}")
	public List<ArticleCommande> findByIdCommande(@PathVariable UUID idCommande) {
		return repository.findByIdCommande(idCommande);
	}

	@GetMapping("/design/{design}")
	public List<ArticleCommande> findByIdDesign(@PathVariable String design) {
		return repository.findByDesign(design);
	}

	@DeleteMapping("/del/{id}")
	public void del(@PathVariable UUID id) {
		repository.deleteById(id);
	}

	@GetMapping("/{idCommande}/montant")
	public double getMontant(@PathVariable UUID idCommande) {
		return repository.getMontant(idCommande);
	}

	@PostMapping("/post")
	public void onSave(@RequestBody ArticleCommande articleCommande) {
		service.save(articleCommande);
	}

	/*@PutMapping("/put/{id}")
	public void onEdit(@RequestBody ArticleCommande articleCommande, @PathVariable UUID id) {
		System.out.println("salamo alaykom edit art=" + articleCommande);
		service.onEdit(articleCommande, id);
	}*/
}
