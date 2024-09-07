package com.example.miniProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.miniProject.Binding.*;
import com.example.miniProject.Entity.*;
import com.example.miniProject.Service.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	
	@Autowired
	private Enquiry_svc enquirySvc;
	
	@GetMapping("/enquiry")
	public String enqPage(Model model) {
		
		model.addAttribute("stu_enq_info",new stu_enq_info());
		return "addEnqView";		
	}
	
	@PostMapping("/enquiry")
	public String addEnquiry(stu_enq_info se, HttpServletRequest req ,Model model) {
		HttpSession session=req.getSession(false);
		Object sessionObj=session.getAttribute("CID");
		se.setCid((Integer)sessionObj);
		
		boolean obj=enquirySvc.addEnq(se);
		
		if(obj) {
			model.addAttribute("success","Enquiry has been added");
		}else {
			model.addAttribute("err","failed to add");
		}
		
		return "addEnqView";
	}
	
	@GetMapping("/enquiries")
	public String viewEnquiry(HttpServletRequest req, Model model) {
		HttpSession session=req.getSession(false);
		Object sessionObj=session.getAttribute("CID");
		model.addAttribute("searchCriteria",new SearchCriteria());
		List<stu_enq_info> enquiriesList=enquirySvc.getEnquiries((Integer)sessionObj, new SearchCriteria());
		model.addAttribute("enquiries",enquiriesList);
		
		return "displayEnqView";
	}
	
	@PostMapping("/filter-enquiries")
	public String filterEnquiries(SearchCriteria sc,HttpServletRequest req,Model model) {
		
		HttpSession session=req.getSession(false);
		Object sessionObj=session.getAttribute("CID");
		System.out.println(sc);
		List<stu_enq_info> enquiriesList=enquirySvc.getEnquiries((Integer)sessionObj, sc);
		model.addAttribute("enquiries",enquiriesList);
		return "displayEnqView";
	}

}
