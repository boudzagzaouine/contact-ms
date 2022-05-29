package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Article;

@TransactionalService
public class ArticleService extends AbstractService<Article, UUID> {

	public List<Article> init() throws Exception {
		List<Article> articles = new ArrayList<>();
		File f = new File("src/main/resources/init/famille_articles.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String word = sc.nextLine().trim();
			Article article = new Article();
			article.setDesign(word);
			articles.add(article);
		}
		sc.close();
		return articles;

	}
}
