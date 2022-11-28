package com.example.JPAdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;



//@SpringBootApplication
public class  EmployeeApplication{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeApplication.class, args);
	}

		@Bean
		public Function<String, String> lsreverse() {
			 return (input) -> new StringBuilder(input).reverse().toString();
		}

		/*UserDao obj = new UserDao();
		obj.readFile();
		obj.addUserDetails();*/
		//obj.removeData();
		//obj.updateData();

}
