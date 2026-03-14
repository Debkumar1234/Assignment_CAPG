package com.springcore.Spring2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("101")
	private int id;
	@Value("Debkumar")
	private String name;
	@Value("xyz@gmail.com")
	private String email;
	@Value("1000000")
	private double salary;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
}
