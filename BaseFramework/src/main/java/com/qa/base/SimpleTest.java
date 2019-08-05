package com.qa.base;

public class SimpleTest {

	private final static String FilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	public static String ChromePath=((System.getProperty("user.dir")+ "/src/main/resources/Drivers/chromedriver.exe"));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(FilePath);
		

	}

}
