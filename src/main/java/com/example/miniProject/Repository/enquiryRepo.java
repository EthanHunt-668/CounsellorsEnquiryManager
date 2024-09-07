package com.example.miniProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniProject.Entity.stu_enq_info;

@Repository
public interface enquiryRepo extends JpaRepository<stu_enq_info,Integer> {

	public List<stu_enq_info> findBycid(Integer cid);
	stu_enq_info findBysPhone(String sPhone);
	public List<stu_enq_info> findBysClassModeAndCid(String sClassMode,Integer cid);
	public List<stu_enq_info> findBysCourseAndCid(String sCourse,Integer cid);
	public List<stu_enq_info> findBysEnqStatusAndCid(String sEnqStatus,Integer cid);
	
}
