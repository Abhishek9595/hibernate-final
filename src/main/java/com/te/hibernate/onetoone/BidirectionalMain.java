package com.te.hibernate.onetoone;

import javax.persistence.*;

public class BidirectionalMain {

	public static void main(String[] args) {
		Passport passport = new Passport();
		passport.setPassId(3);
		passport.setPassNum("1234EFGH");
		Person person = new Person();
		person.setPId(300);
		person.setPName("Williamson");
		passport.setPerson(person);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(passport);
			manager.persist(person);
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
