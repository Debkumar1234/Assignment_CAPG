package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();

		Employee e1 = new Employee(1, "one", 100000.000);
		Employee e2 = new Employee(2, "two", 200000.000);
		Employee e3 = new Employee(3, "three", 300000.000);
		Employee e4 = new Employee(4, "four", 400000.000);
		// insert Employee
		s.save(e1);
		s.save(e2);
		s.save(e3);
		s.save(e4);
		System.out.println("Inserted successfully");

		// Fetch employee details

		Employee e5 = s.get(Employee.class, 2);
		System.out.println(e5);

		// update employee details
		e5.setSalary(200050.00);
		System.out.println(e5);

		// delete employee id 4
		Employee e6 = s.get(Employee.class, 4);
		s.delete(e6);
		System.out.println("Employee deleted successfully");

		Transaction t = s.beginTransaction();

		t.commit();
	}

}
