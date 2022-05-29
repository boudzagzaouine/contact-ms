package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.ArticleClient;

@TransactionalService
public class ArticleClientService extends AbstractService<ArticleClient, UUID> {

	public List<ArticleClient> init() throws Exception {
		List<ArticleClient> articles = new ArrayList<>();
		File f = new File("src/main/resources/init/articles_clients.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String word = sc.nextLine().trim();
			String[] sub = word.split("##");
			ArticleClient article = new ArticleClient();
			String design = sub[0];
			UUID idClient = UUID.fromString(sub[1]);
			UUID idFamilleArticle = UUID.fromString(sub[2]);
			UUID idFournisseur = UUID.fromString(sub[3]);
			long poid = Long.valueOf(sub[4]);
			double prix = Double.valueOf(sub[5]);
			article.setDesign(design);
			article.setIdClient(idClient);
			article.setIdFamilleArticle(idFamilleArticle);
			article.setIdFournisseur(idFournisseur);
			article.setPoid(poid);
			article.setPrix(prix);
			articles.add(article);
		}
		sc.close();
		return articles;

	}
}
