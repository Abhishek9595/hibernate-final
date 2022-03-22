package com.te.hibernate.crud;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicFetchSingle {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			String query="from Student where id= :id";
			Query query2= manager.createQuery(query);
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter the id:");
			int id=scanner.nextInt();
			query2.setParameter("id", id);
			Student student= (Student) query2.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (factory != null)
					factory.close();
				if (manager != null)
					manager.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
