package com.ids.service;

import org.springframework.stereotype.Service;

import com.ids.entity.ArticleCommande;
import com.ids.entity.Commande;
import com.ids.repository.ArticleCommandeRepository;
import com.ids.repository.CommandeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleCommandeService {
	private CommandeRepository comandDao;
	private ArticleCommandeRepository articleDao;

	/*public void onSave(ArticleCommande articleCommande) {
		articleDao.save(articleCommande);
		Commande commande = comandDao.findById(articleCommande.getIdCommande()).get();
		List<ArticleCommande> lc = commande.getArticleCommandes();
		lc.add(articleCommande);
		commande.setArticleCommandes(lc);
		comandDao.save(commande);
	}
	
	public void onEdit(ArticleCommande articleCommande, UUID id) {
		ArticleCommande articleCommande0 = articleDao.findById(id).get();
		articleDao.save(articleCommande);
		Commande commande = comandDao.findById(articleCommande.getIdCommande()).get();
		List<ArticleCommande> lc = commande.getArticleCommandes();
		lc.remove(articleCommande0);
		lc.add(articleCommande);
		commande.setArticleCommandes(lc);
		comandDao.save(commande);
	}*/
	public void save(ArticleCommande articleCommande) {
		articleDao.save(articleCommande);
		Commande commande = comandDao.findById(articleCommande.getIdCommande()).get();
		commande.setAmount(commande.getAmount() + (articleCommande.getQte() * articleCommande.getPu()));
		comandDao.save(commande);
	}
}
