package com.ids.repository;

import java.util.List;
import java.util.UUID;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.Document;

public interface DocumentRepository extends BaseRepository<Document, UUID> {
	public List<Document> findByDesignation(String designation);

}
