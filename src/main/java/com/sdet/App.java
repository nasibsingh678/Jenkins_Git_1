package com.sdet;

import java.util.ResourceBundle;

public class App {
 public int userLogin(String in_user,String in_pwd)
 {
	String path=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	ResourceBundle rb=ResourceBundle.getBundle(path);
	String userName=rb.getString("username");
	String password=rb.getString("password");
	if(in_user.equals(userName) && in_pwd.equals(password))
		return 1;
	else
		return 0;
 }
}
