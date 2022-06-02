package com.ids.repository;

import java.util.List;
import java.util.UUID;

import com.ids.data.repository.BaseRepository;
import com.ids.entity.Type;

public interface TypeRepository extends BaseRepository<Type, UUID> {
	public List<Type> findByDesign(String designation);

}
