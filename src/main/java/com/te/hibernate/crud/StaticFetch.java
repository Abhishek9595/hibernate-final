package com.te.hibernate.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StaticFetch {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			Student student = manager.find(Student.class, 200);
			System.out.println(student.getName());
			System.out.println(student.getLocation());
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
