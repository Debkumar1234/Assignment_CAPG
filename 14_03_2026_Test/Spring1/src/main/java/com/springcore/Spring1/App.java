package com.springcore.Spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
        Employee em = (Employee) context.getBean("employee");
        System.out.println(em);
    }
}
