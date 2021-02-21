package com.edu.gdut.imis.CommunityMIS.bean;

import java.util.Date;


@SuppressWarnings("serial")
public class User implements java.io.Serializable {
		
		private Integer id;
		private String username;
		private String password;
		private Integer mean;
		private String name;
		private String birthday;
		private String area;
		private Date createdate;
		private String phone;
		private String sex;
		private Integer state;

		
		public User() {
			
		}

		public User(String username, String password, Integer mean, String name, String birthday, String area,
				Date createdate, String phone,String sex,Integer state) {
			this.username = username;
			this.password = password;
			this.mean = mean;
			this.name = name;
			this.birthday = birthday;
			this.area = area;
			this.createdate = createdate;
			this.phone = phone;
			this.setSex(sex);
			this.setState(state);
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getMean() {
			return mean;
		}

		public void setMean(Integer mean) {
			this.mean = mean;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public Date getCreatedate() {
			return createdate;
		}

		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}


}
