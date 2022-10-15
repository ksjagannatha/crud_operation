package com.auraspin.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.auraspin.demo.entity.CreateEntity;

public interface CreateService {

	CreateEntity createData(CreateEntity requestBody);

	List<CreateEntity> allData();

	Optional<CreateEntity> findById(String id);

	CreateEntity updateBy(String id,  Map<String,String>  requestBody);

	Map<String,String> deleteById(String id);

}
