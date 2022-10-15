package com.auraspin.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auraspin.demo.entity.CreateEntity;
import com.auraspin.demo.service.CreateService;


@RestController
public class CreateController {
	
	@Autowired
	CreateService createService;
	
	
	@PostMapping("/create")
	public CreateEntity insertData(@RequestBody CreateEntity requestBody){
		return createService.createData(requestBody);
	}
	
	@GetMapping("/allData")
	public List<CreateEntity> getData(){
		return createService.allData();
	}
	@GetMapping("/getById/{id}")
	public Optional<CreateEntity> find(@PathVariable String id){
		return createService.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public CreateEntity  update(@PathVariable String id, @RequestBody Map<String,String> requestBody) {
		return createService.updateBy(id,requestBody);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,String> delete(@PathVariable String id) {
		return createService.deleteById(id);
	}
	
}
