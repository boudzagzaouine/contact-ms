package com.ids.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.ArticleCommande;

public interface ArticleCommandeRepository extends BaseRepository<ArticleCommande, UUID> {
	public List<ArticleCommande> findByIdCommande(UUID idCommande);

	public List<ArticleCommande> findByDesign(String design);

	// group by a.pu 
	@Query("select sum(a.pu*a.qte) from ArticleCommande a where a.idCommande=:idCommande")
	public Double getMontant(@Param("idCommande") UUID idCommande);
}
