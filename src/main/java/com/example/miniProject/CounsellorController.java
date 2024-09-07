package com.example.miniProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.miniProject.Entity.*;
import com.example.miniProject.Service.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.miniProject.Binding.*;

@Controller
public class CounsellorController {

	@Autowired
	private Counsellors_svc counsellorSvc;
	
	@Autowired
	private DashboardResponse dashboardResponse;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("counsellors_info", new counsellors_info());
		return "loginView";
	}
	
	@GetMapping("/register")
	public String regPage(Model model) {
		model.addAttribute("counsellors_info",new counsellors_info());
		return "registerView";
	}
	
	@GetMapping("/forgot-pwd")
	public String recoverPwdPage(Model model) {
		return "forgotPwdView";
	}
	
	@PostMapping("/register")
	public String handleRegistration(counsellors_info c, Model model) {
		
		String msg= counsellorSvc.saveCounsellor(c);
		model.addAttribute("msg", msg);
		
		return "registerView";
	}
	@PostMapping("/login")
	public String handleLogin(counsellors_info c, HttpServletRequest req ,Model model) {
		counsellors_info obj=counsellorSvc.loginCheck(c.getcEmail() ,c.getcPwd());
		
		System.out.println(obj);
		
		if(obj == null) {
			model.addAttribute("err","Invalid Credentials");
			return "loginView";
		}
		
		HttpSession session=req.getSession(true);
		session.setAttribute("CID", obj.getCid());
		
		return "redirect:dashboard";
	}
	@GetMapping("/dashboard")
	public String buildDashboard(HttpServletRequest req, Model model) {
		HttpSession session=req.getSession(false);
		Object obj =session.getAttribute("CID");
		Integer cid=(Integer) obj;
		DashboardResponse dashboardInfo=counsellorSvc.getDashboardInfo(cid);
		model.addAttribute("dashboard",dashboardInfo);
		return "dashboardView";
	}
	
	@GetMapping("/recover-pwd")
	public String recoverPwd(@RequestParam(value="cEmail") String cEmail, Model model) {
		boolean msg = counsellorSvc.recoverPwd(cEmail);
		if(msg) {
		model.addAttribute("msg", "Password Sent to Email");
		}else {
			model.addAttribute("errMsg","Invalid Email");
		}
		
		return "forgotPwdView";
	}
}
