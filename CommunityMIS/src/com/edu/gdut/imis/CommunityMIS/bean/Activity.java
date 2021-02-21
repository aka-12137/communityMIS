package com.edu.gdut.imis.CommunityMIS.bean;

import java.util.Date;

@SuppressWarnings("serial")
public class Activity implements java.io.Serializable {


	   private Integer id;
	   private String theme;
	   private Date createdate;
	   private String content;
	   private Date time;
	   private String place;
	   private String sponsor;
	   private String backup;


	   public Activity() {
		   
	   	}

	   public Activity(String theme, Date createdate, String content, Date time,
			String place, String sponsor, String backup) {
		   this.theme = theme;
		   this.createdate = createdate;
		   this.content = content;
		   this.time = time;
	       this.place = place;
	       this.sponsor = sponsor;
		   this.backup = backup;
	}

	   public Integer getId() {
		   return id;
	}

	   public void setId(Integer id) {
		   this.id = id;
	}

	   public String getTheme() {
		   return theme;
	}

	   public void setTheme(String theme) {
		   this.theme = theme;
	}

	   public Date getCreatedate() {
		   return createdate;
	}

	   public void setCreatedate(Date createdate) {
		   this.createdate = createdate;
	}

	   public String getContent() {
		   return content;
	}

	   public void setContent(String content) {
		   this.content = content;
	}

	   public Date getTime() {
		   return time;
	}

	   public void setTime(Date time) {
		   this.time = time;
	}

	   public String getPlace() {
		   return place;
	}

	   public void setPlace(String place) {
		   this.place = place;
	}

	   public String getSponsor() {
		   return sponsor;
	}

	   public void setSponsor(String sponsor) {
		   this.sponsor = sponsor;
	}

	   public String getBackup() {
		   return backup;
	}

	   public void setBackup(String backup) {
		   this.backup = backup;
	}
    

}
