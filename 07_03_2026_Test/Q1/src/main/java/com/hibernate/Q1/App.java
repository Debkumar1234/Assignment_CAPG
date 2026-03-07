package com.hibernate.Q1;

import java.time.LocalDate;

import com.hibernate.Q1.models.Customer;
import com.hibernate.Q1.models.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		// Insert some sample data
		// 1
		Order o1 = new Order(101, "ORD001", "Laptop", 1, 65000, LocalDate.of(2024, 1, 10), null);
		Customer c1 = new Customer(1, "Rahul", "rahul@gmail.com", "Male", 9876543210L, LocalDate.of(2024, 1, 5), o1);
		o1.setCustomer(c1);

		// 2
		Order o2 = new Order(102, "ORD002", "Mobile", 2, 40000, LocalDate.of(2024, 2, 12), null);
		Customer c2 = new Customer(2, "Ananya", "ananya@gmail.com", "Female", 9876543211L, LocalDate.of(2024, 2, 8),
				o2);
		o2.setCustomer(c2);

		// 3
		Order o3 = new Order(103, "ORD003", "Headphones", 1, 3000, LocalDate.of(2024, 3, 15), null);
		Customer c3 = new Customer(3, "Arjun", "arjun@gmail.com", "Male", 9876543212L, LocalDate.of(2024, 3, 10), o3);
		o3.setCustomer(c3);

		// 4
		Order o4 = new Order(104, "ORD004", "Keyboard", 1, 1500, LocalDate.of(2024, 4, 20), null);
		Customer c4 = new Customer(4, "Sneha", "sneha@gmail.com", "Female", 9876543213L, LocalDate.of(2024, 4, 18), o4);
		o4.setCustomer(c4);

		// 5
		Order o5 = new Order(105, "ORD005", "Monitor", 1, 12000, LocalDate.of(2024, 5, 22), null);
		Customer c5 = new Customer(5, "Vikram", "vikram@gmail.com", "Male", 9876543214L, LocalDate.of(2024, 5, 19), o5);
		o5.setCustomer(c5);

		// 6
		Order o6 = new Order(106, "ORD006", "Mouse", 2, 2000, LocalDate.of(2024, 6, 10), null);
		Customer c6 = new Customer(6, "Priya", "priya@gmail.com", "Female", 9876543215L, LocalDate.of(2024, 6, 7), o6);
		o6.setCustomer(c6);

		// persist only customer (cascade will save order)
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		em.persist(c6);
		
		et.commit();
		
		em.close();
		emf.close();
	}
}
