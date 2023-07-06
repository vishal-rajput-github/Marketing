package com.marketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;


@Service

public class LeadServiceImpl implements Leadservice{
	
	@Autowired
	private LeadRepository leadRepository;
	
	@Override
	public void saveRegistration(Lead lead) {
		leadRepository.save(lead);
	}

	@Override
	public List<Lead> findList() {
		List<Lead> lead = leadRepository.findAll();
		return lead;
	}

	@Override
	public void deleteById(long id) {
		leadRepository.deleteById(id);
		
	}

	@Override
	public Lead updateLead(long id) {
		Optional<Lead> findById = leadRepository.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
