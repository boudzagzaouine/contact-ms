package com.ids.repository;

import java.util.List;
import java.util.UUID;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.Fournisseur;

public interface FournisseurRepository extends BaseRepository<Fournisseur, UUID> {
	public List<Fournisseur> findByRaisonSociale(String raisonSociale);
}
