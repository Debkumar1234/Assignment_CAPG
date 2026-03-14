package com.springcore.Spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.Spring2.Employee;

public class App {
  public static void main(String[] args) {
	  ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config.xml");
      Employee em = context.getBean(Employee.class);
      System.out.println(em);
  }
}
