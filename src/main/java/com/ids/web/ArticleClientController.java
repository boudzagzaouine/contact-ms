package com.ids.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.ArticleClient;
import com.ids.repository.ArticleClientRepository;
import com.ids.service.ArticleClientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/articleclients")
@CrossOrigin("*")
@AllArgsConstructor
public class ArticleClientController extends AbstractCrudController<ArticleClient, UUID> {
	private ArticleClientRepository repository;
	private ArticleClientService service;

	@GetMapping("/idclient/{idClient}")
	public Map<String, List<ArticleClient>> ByIdClient(@PathVariable UUID idClient) {
		return new HashMap<String, List<ArticleClient>>() {
			{
				put("content", repository.findByIdClient(idClient));
			}
		};
	}

	@GetMapping("/parent/{idClient}")
	public Map<String, List<ArticleClient>> ByIdClient2(@PathVariable UUID idClient) {
		return new HashMap<String, List<ArticleClient>>() {
			{
				put("content", repository.findByIdClient(idClient));
			}
		};
	}

	@PutMapping("/test/{id}")
	public void test(@RequestBody ArticleClient articleClient, @PathVariable String id) {
		System.out.println("---------------------------------------------");
		for (int i = 0; i < 7; i++) {
			System.out.println("tets id= " + id + " art= " + articleClient);
		}
		System.out.println("---------------------------------------------");

	}
}
