package com.example.miniProject.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class counsellors_info {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	
	private String cName;
	private String cEmail;
	private String cPwd;
	private String cPhone;
	
	
	public Integer getCid() {
		return cid;
	}
	
//	public void getCid(Integer cid) {
//		this.cid=cid;
//	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPwd() {
		return cPwd;
	}

	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	
	@Override
	public String toString() {
		return "counsellors_info [cid=" + cid + ", cName=" + cName + ", cEmail=" + cEmail + ", cPwd=" + cPwd
				+ ", cPhone=" + cPhone + "]";
	}

	


	public counsellors_info(Integer cid, String cName, String cEmail, String cPwd, String cPhone) {
		super();
		this.cid = cid;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cPwd = cPwd;
		this.cPhone = cPhone;
	}

	public counsellors_info() {
		super();
	}
	
}
