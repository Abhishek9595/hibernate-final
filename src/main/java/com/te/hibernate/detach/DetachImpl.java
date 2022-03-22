package com.te.hibernate.detach;

import javax.persistence.*;

import com.te.hibernate.crud.Student;

public class DetachImpl {
	static EntityManagerFactory factory = null;
	static EntityManager manager = null;
	static EntityTransaction transaction = null;

	public static void main(String[] args) {
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Student student = manager.find(Student.class, 500);
			System.out.println(student);
			manager.detach(student);
			Student student2= manager.merge(student);
			manager.remove(student);
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
