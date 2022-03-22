package com.te.hibernate.crud;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdateByJpql {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String query = "update Student set name= :name, location= :loc where id= :id";
			Query update = manager.createQuery(query);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the id:");
			int idUpdate = scanner.nextInt();
			System.out.println("Set the name:");
			String nameUpdate = scanner.next();
			System.out.println("Set the loaction");
			String locUpdate = scanner.next();
			update.setParameter("name", nameUpdate);
			update.setParameter("loc", locUpdate);
			update.setParameter("id", idUpdate);
			// update using command line
//			update.setParameter("name", args[0]);
//			update.setParameter("loc", args[1]);
//			update.setParameter("id", Integer.parseInt(args[2]));
			int result = update.executeUpdate();
			System.out.println("Data updated successfully");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
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
