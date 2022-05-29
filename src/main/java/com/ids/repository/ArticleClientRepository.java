package com.ids.repository;

import java.util.List;
import java.util.UUID;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.ArticleClient;

public interface ArticleClientRepository extends BaseRepository<ArticleClient, UUID> {
	public List<ArticleClient> findByIdClient(UUID idClient);
}
