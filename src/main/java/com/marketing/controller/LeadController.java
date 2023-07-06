package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.Dto.LeadDto;
import com.marketing.entities.Lead;
import com.marketing.service.Leadservice;
import com.marketing.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private Leadservice leadservice;
	
	
	@Autowired
	private EmailService emailService;
	
	//localhost:8080/create
	@RequestMapping("/create")
	public String createLead() {
		
		return "create_lead";
	}
	
	@RequestMapping("/SaveReg")
	public String saveRegis(@ ModelAttribute Lead lead, Model model) {
		leadservice.saveRegistration(lead);
		emailService.emailSend(lead.getCourse(), "Test", "Testing Email Services");
		model.addAttribute("msg", "data is saved");
		return "create_lead";
		
	}
	
	//localhost:8080/listall
	@RequestMapping("/listall")
	public String giveAll(Model model) {
		List<Lead> leads = leadservice.findList();
		model.addAttribute("leads", leads);
		return "All_Leads";	
		
	}
	
	//localhost:8080/delete
	@RequestMapping("/delete")
	public String deleteId(@RequestParam("id") long id,Model model) {
		leadservice.deleteById(id);
		List<Lead> leads = leadservice.findList();
		model.addAttribute("leads", leads);
		return "All_Leads";	
		
	}
	
	//localhost:8080/update
	@RequestMapping("/update")
	public String updateById(@RequestParam("id") long id, Model model) {
		Lead lead = leadservice.updateLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/editReg")
	public String editReg(LeadDto dto,Model model) {
		
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstname(dto.getFirstname());
		lead.setSecondname(dto.getSecondname());
		lead.setCourse(dto.getCourse());
		lead.setFee(dto.getFee());
		
		leadservice.saveRegistration(lead);
		
		List<Lead> leads = leadservice.findList();
		model.addAttribute("leads", leads);
		return "All_Leads";	
		
	}
}
//	@RequestMapping("/SaveReg")
//	public String saveRegis(@RequestParam("firstname") String firstname,
//			@RequestParam("secondname") String secondname,
//			@RequestParam("course") String course,
//			@RequestParam("fee") int fee, Model model)
//	{
//		Lead l = new Lead();
//		l.setFirstname(firstname);
//		l.setSecondname(secondname);
//		l.setCourse(course);
//		l.setFee(fee);
//		
//		leadservice.saveRegistration(l);
//		model.addAttribute("msg", "Leads is saved");
//		return "create_lead";
//	}
	
	
//	@RequestMapping("/SaveReg")
//	public String saveRegis(LeadDto dto, Model model) {
//		
//		Lead lead = new Lead();
//		lead.setFirstname(dto.getFirstname());
//		lead.setSecondname(dto.getSecondname());
//		lead.setCourse(dto.getCourse());
//		lead.setFee(dto.getFee());
//		
//		leadservice.saveRegistration(lead);
//		model.addAttribute("msg", "saved!!");
//		return "create_lead";
//	}
	

