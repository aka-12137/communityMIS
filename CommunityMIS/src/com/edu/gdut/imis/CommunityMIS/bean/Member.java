package com.edu.gdut.imis.CommunityMIS.bean;

import java.util.Date;

@SuppressWarnings("serial")
public class Member implements java.io.Serializable {


	   private Integer id;
	   private String name;
	   private Date createdate;
	   private String department;
	   private String sex;
	   private String duty;
	   private String phone;


	   public Member() {
		   
	   	}

	   public Member(Integer id, String name, String department, Date createdate,
			String sex, String duty,String phone) {
		   this.id = id;
		   this.name = name;
		   this.department = department;
		   this.createdate = createdate;
	       this.sex = sex;
	       this.duty = duty;
	       this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



}
