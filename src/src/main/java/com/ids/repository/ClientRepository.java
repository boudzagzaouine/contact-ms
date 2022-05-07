package com.ids.repository;

import java.util.List;
import java.util.UUID;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.Client;

public interface ClientRepository extends BaseRepository<Client, UUID> {

	List<Client> findByDesign(String design);
}
