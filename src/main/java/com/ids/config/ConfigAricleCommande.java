package com.ids.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ids.entity.ArticleCommande;
import com.ids.repository.ArticleCommandeRepository;
import com.ids.repository.CommandeRepository;

@Configuration
public class ConfigAricleCommande {

	CommandLineRunner go2(CommandeRepository comDao, ArticleCommandeRepository artDao) {
		return a -> {
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			comDao.findAll().forEach(c -> {
				System.out.println("--------------------------------------------");
				if (c.getAmount() == 0) {

					List<ArticleCommande> la = artDao.findByIdCommande(c.getId());
					double amount = la.stream().map((t) -> t.getQte() * t.getPu()).reduce(0.0, Double::sum);
					//c.setAmount(amount);
					//comDao.save(c);
					System.out.println("mon =" + amount + " com= " + c);
				}
			});
		};
	}
}
