package com.example.JPAdemo;

import com.example.JPAdemo.DAO.UserDao;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class  EmployeeApplication{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeApplication.class, args);
		UserDao obj = new UserDao();
		obj.readFile();
		obj.addUserDetails();
		//obj.removeData();
		//obj.updateData();
	}
}
