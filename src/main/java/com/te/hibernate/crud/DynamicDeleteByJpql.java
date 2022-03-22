package com.te.hibernate.crud;

import java.util.Scanner;

import javax.persistence.*;

public class DynamicDeleteByJpql {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String query = "delete from Student where id= :id";
			Query query2 = manager.createQuery(query);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the id:");
			int idDelete = scanner.nextInt();
			query2.setParameter("id", idDelete);
			int result = query2.executeUpdate();
			System.out.println("Data deleted successfully");
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
