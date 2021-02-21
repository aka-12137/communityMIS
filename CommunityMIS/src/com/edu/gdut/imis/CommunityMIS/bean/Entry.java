package com.edu.gdut.imis.CommunityMIS.bean;

import java.util.Date;

@SuppressWarnings("serial")
public class Entry implements java.io.Serializable {


		private Integer id;
		private Integer aid;
		private Integer uid;
		private Integer state;
		private String name;
		private String sex;
		private String phone;
		private String backup;
		private Date createdate;

		public Entry() {
	}

		public Entry(Integer aid,Integer uid, Integer state, String name,
				String sex, String phone, String backup, Date createdate) {
			this.aid = aid;
			this.setUid(uid);
			this.state = state;
			this.name = name;
			this.sex = sex;
			this.phone = phone;
			this.backup = backup;
			this.createdate = createdate;
	}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getAid() {
			return aid;
		}

		public void setAid(Integer aid) {
			this.aid = aid;
		}

		public Integer getUid() {
			return uid;
		}

		public void setUid(Integer uid) {
			this.uid = uid;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getBackup() {
			return backup;
		}

		public void setBackup(String backup) {
			this.backup = backup;
		}

		public Date getCreatedate() {
			return createdate;
		}

		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}
 
}