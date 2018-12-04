package com.infosys.babynamegenerator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.babynamegenerator.business.service.IGenerateNames;

@RequestMapping("${base_endpoint}")
@RestController
@CrossOrigin
public class NameEndpoint implements INameEndpoint {
	
	@Autowired
	private IGenerateNames service;

	@PostMapping("${create_endpoint}")
	public String generateName(@PathVariable("length") Integer desiredLength, @PathVariable("name") String initialName) {
		return service.generateName(desiredLength, initialName);
	}
}
