package com.marketing.service;

import java.util.List;

import com.marketing.entities.Lead;


public interface Leadservice {
	
	public void saveRegistration(Lead lead);

	public List<Lead> findList();

	public void deleteById(long id);

	public Lead updateLead(long id);


}
