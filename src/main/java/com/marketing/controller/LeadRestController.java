package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.Dto.LeadDto;
import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;


@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepository;
	
	
	//localhost:8080/api/leads
	@GetMapping
	public List<Lead> getLead() {
		List<Lead> list = leadRepository.findAll();
		return list;
	}
	
	//localhost:8080/api/leads
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
			

		leadRepository.save(lead);
		
	}
	
	//localhost:8080/api/leads/{id}
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") long id) {
		leadRepository.deleteById(id);
	}
	
	//localhost:8080/api/leads
	@PutMapping()
	public void update(@RequestBody LeadDto lead) {
		
		Lead dto = new Lead();
		dto.setFirstname(lead.getFirstname());
		dto.setSecondname(lead.getSecondname());
		dto.setCourse(lead.getCourse());
		dto.setFee(lead.getFee());
		leadRepository.save(dto);
	}

}
