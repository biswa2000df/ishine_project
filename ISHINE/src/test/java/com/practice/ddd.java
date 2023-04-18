package com.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ddd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		   SimpleDateFormat tm=new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
		   String format = tm.format(date);
		   System.out.println(format);
	}

}
