package com.example.miniProject.Binding;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SearchCriteria{

	private String courseName;
	private String enqStatus;
	private String mode;
}
