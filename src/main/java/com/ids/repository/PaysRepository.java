package com.ids.repository;

import java.util.List;
import java.util.UUID;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.Document;
import com.ids.entity.Pays;

public interface PaysRepository extends BaseRepository<Pays, UUID> {
	public List<Document> findByDesign(String designation);

}