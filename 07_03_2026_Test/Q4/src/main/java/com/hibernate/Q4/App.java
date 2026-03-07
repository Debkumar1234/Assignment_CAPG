package com.hibernate.Q4;

import java.time.LocalDate;

import com.hibernate.Q4.models.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-hibernate-mysql");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

//        Insert raw data
//        Customer c1 = new Customer(1,"Rahul","rahul@gmail.com","Male",9876543210L,LocalDate.of(2024,1,5));
//        Customer c2 = new Customer(2,"Ananya","ananya@gmail.com","Female",9876543211L,LocalDate.of(2024,2,10));
//        Customer c3 = new Customer(3,"Arjun","arjun@gmail.com","Male",9876543212L,LocalDate.of(2024,3,12));
//        Customer c4 = new Customer(4,"Sneha","sneha@gmail.com","Female",9876543213L,LocalDate.of(2024,4,15));
//        Customer c5 = new Customer(5,"Vikram","vikram@gmail.com","Male",9876543214L,LocalDate.of(2024,5,18));
//        Customer c6 = new Customer(6,"Priya","priya@gmail.com","Female",9876543215L,LocalDate.of(2024,6,20));
//
//        em.persist(c1);
//        em.persist(c2);
//        em.persist(c3);
//        em.persist(c4);
//        em.persist(c5);
//        em.persist(c6);

        String jpql = "SELECT c FROM Customer c WHERE c.email = :email";

        Customer customer = em.createQuery(jpql, Customer.class)
                              .setParameter("email", "rahul@gmail.com")
                              .getSingleResult();

        System.out.println(customer);
        

        et.commit();

        em.close();
        emf.close();
    }
}
