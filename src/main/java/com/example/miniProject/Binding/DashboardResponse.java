package com.example.miniProject.Binding;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DashboardResponse {
	private Integer totalEnq =0;
	private Integer enrolledEnq=0;
	private Integer lostEnq=0;
	
	
}
