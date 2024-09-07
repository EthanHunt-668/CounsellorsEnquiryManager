package com.example.miniProject.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class stu_enq_info {

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsClassMode() {
		return sClassMode;
	}
	public void setsClassMode(String sClassMode) {
		this.sClassMode = sClassMode;
	}
	public String getsCourse() {
		return sCourse;
	}
	public void setsCourse(String sCourse) {
		this.sCourse = sCourse;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getsEnqStatus() {
		return sEnqStatus;
	}
	public void setsEnqStatus(String sEnqStatus) {
		this.sEnqStatus = sEnqStatus;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	
	private Integer cid;
	private String sName;
	private String sClassMode;
	private String sCourse;
	private String sPhone;
	private LocalDate date;
	private String sEnqStatus;
}
