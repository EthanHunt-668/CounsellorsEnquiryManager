package com.example.miniProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.miniProject.Entity.counsellors_info;

@Repository
public interface counsellorsRepo extends JpaRepository<counsellors_info, Integer> {
	
	counsellors_info findBycEmail(String cEmail);
	
}
