package com.edu.gdut.imis.CommunityMIS.util;

import java.sql.Timestamp;
import java.util.Date;

public class StringUtils {

	public static boolean isEmpty(String str){
		if("".equals(str) || str == null){
			return true;
		}
		
		return false;
	}
	public static boolean isEmpty(Integer str){
		if("".equals(str) || str == null){
			return true; 
		}
		
		return false;
	}
	public static boolean isEmpty(Timestamp str){
		if("".equals(str) || str == null){
			return true;
		}
		
		return false;
	}
	public static boolean isEmpty(java.sql.Date str){
		if("".equals(str) || str == null){
			return true;
		}
		
		return false;
	}
	public static boolean isEmpty(java.util.Date str){
		if("".equals(str) || str == null){
			return true;
		}
		
		return false;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args){
		Double countsize = 30000.23;
		Double zhi=(Double) (countsize/20000.22);
		int ye = (int) Math.ceil(zhi);
		System.out.println(zhi.intValue());
		
	}
	
	public static String uuid(){
		Date now = new Date();
		
		Date begin = DateUtils.formDate("2020-01-01", "yyyy-MM-dd");
		
		long time = now.getTime() - begin.getTime();
		
		String uuid = String.valueOf(time).substring(0, 11);
		
		return uuid;
	}
	
}
