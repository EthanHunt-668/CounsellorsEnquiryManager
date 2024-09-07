package com.example.miniProject.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.miniProject.Binding.*;
import com.example.miniProject.Entity.*;
import com.example.miniProject.Repository.*;

@Service
public class Enquiry_svc {
	
	@Autowired
	private enquiryRepo enquiryRepo;
	
	public boolean addEnq(stu_enq_info se) {
		se.setDate(LocalDate.now());
		stu_enq_info checkPhone= enquiryRepo.findBysPhone(se.getsPhone());
		if(checkPhone!=null) {
			return false;
		}
		
		stu_enq_info obj=enquiryRepo.save(se);
		
		if(obj!=null) {
			return true;
		}
		return false;
	}
	
	public List<stu_enq_info> getEnquiries(Integer cid, SearchCriteria s){
		
		stu_enq_info searchObj= new stu_enq_info();
		searchObj.setCid(cid);
		
		if(s.getMode()!=null && !s.getMode().equals("")) {
			searchObj.setsClassMode(s.getMode());
		}
		if(s.getCourseName()!=null && !s.getCourseName().equals("")) {
			searchObj.setsCourse(s.getCourseName());
		}
		if(s.getEnqStatus()!=null && !s.getEnqStatus().equals("")){
			searchObj.setsEnqStatus(s.getEnqStatus());
		}
		
		Example <stu_enq_info> of= Example.of(searchObj);
		
		List<stu_enq_info> List=enquiryRepo.findAll(of);
		return List;
	}

}
