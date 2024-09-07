package com.example.miniProject.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniProject.Binding.*;
import com.example.miniProject.Entity.*;
import com.example.miniProject.Repository.*;
import com.example.miniProject.Utilities.EmailUtils;

@Service
public class Counsellors_svc {
	@Autowired
	private counsellorsRepo counsellorRepo;
	@Autowired
	private enquiryRepo enquiryRepo;
	@Autowired
	private EmailUtils email;

	public String saveCounsellor(counsellors_info c) {
		
		counsellors_info object=counsellorRepo.findBycEmail(c.getcEmail());
		if (object!= null) {
			return "User already Registered";
		}
		counsellors_info obj =counsellorRepo.save(c);
		if(obj != null) {
			return "Registration Successful";
		}
		return "Error Registering User";
	}
	
	public counsellors_info loginCheck(String cEmail, String cPwd) {
		
		counsellors_info obj=counsellorRepo.findBycEmail(cEmail);
		
		if(cEmail.equals(obj.getcEmail()) && cPwd.equals(obj.getcPwd())) {
			
			return obj;
		}
		
		return null;
	}
	
	public boolean recoverPwd(String cEmail) {
		
		counsellors_info obj=counsellorRepo.findBycEmail(cEmail);
		if(obj!=null) {
			
			email.sendEmail("Password for CheckIT app", obj.getcPwd(), obj.getcEmail());
			
			return true;
		}
		
		return false;
	}
	
	public DashboardResponse getDashboardInfo(Integer cid) {
		List<stu_enq_info> allEnqs=enquiryRepo.findBycid(cid);
		int enrolledEnqs= allEnqs.stream()
								.filter(e->e.getsEnqStatus().equals("enrolled"))
								.collect(Collectors.toList()).size();
		
		DashboardResponse obj= new DashboardResponse();
		
		obj.setEnrolledEnq(enrolledEnqs);
		obj.setLostEnq(allEnqs.size()-enrolledEnqs);
		obj.setTotalEnq(allEnqs.size());
		
		return obj;
	}
	
	
}
