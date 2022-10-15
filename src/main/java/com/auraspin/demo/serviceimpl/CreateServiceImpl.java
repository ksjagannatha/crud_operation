package com.auraspin.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auraspin.demo.entity.CreateEntity;
import com.auraspin.demo.repository.UserRepository;
import com.auraspin.demo.service.CreateService;

@Service
@Transactional
public class CreateServiceImpl implements CreateService {

	@Autowired
	UserRepository userRepository;

	@Override
	public CreateEntity createData(CreateEntity requestBody) {
		return userRepository.save(requestBody);
	}

	@Override
	public List<CreateEntity> allData() {
		return userRepository.findAll();
	}

	@Override
	public Optional<CreateEntity> findById(String id) {
		Long idBy = Long.parseLong(id);

		return userRepository.findById(idBy);
	}

	@Override
	public CreateEntity updateBy(String id, Map<String, String> requestBody) {
		Long idBy = Long.parseLong(id);
		CreateEntity data = userRepository.findById(idBy).get();
		if (requestBody.containsKey("password")) {
			data.setPassword(requestBody.get("password"));
		}
		if (requestBody.containsKey("username")) {
			data.setUsername(requestBody.get("username"));
		}
		return userRepository.save(data);
	}

	@Override
	public Map<String, String> deleteById(String id) {
		Map<String, String> map = new HashMap<>();
		Long idBy = Long.parseLong(id);
		userRepository.deleteById(idBy);
		map.put("status", "Deleted Success");
		return map;
	}

}
