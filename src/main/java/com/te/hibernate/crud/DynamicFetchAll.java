package com.te.hibernate.crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicFetchAll {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			String query = "from Student";
			Query query2 = manager.createQuery(query);
			List<Student> listStudent = query2.getResultList();
			for (Student student : listStudent) {
				System.out.println(student);
			}
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
