package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.service.AbstractService;
import com.ids.entity.articleFacture;

public class articleFactureService extends AbstractService<articleFacture, UUID> {
	public List<articleFacture> init() throws Exception {
		List<articleFacture> articles = new ArrayList<>();
		File f = new File("src/main/resources/names.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			double prixUnitaire = sc.nextDouble();
			double codeArticle = sc.nextDouble();
			double quantité = sc.nextDouble();
			String designation = sc.nextLine().trim();
			articleFacture article = new articleFacture();
			article.setPrixUnitaire(prixUnitaire);
			article.setCodeArticle(codeArticle);
			article.setQuantité(quantité);
			article.setDesignation(designation);
			articles.add(article);
		}
		return articles;
	}
}
