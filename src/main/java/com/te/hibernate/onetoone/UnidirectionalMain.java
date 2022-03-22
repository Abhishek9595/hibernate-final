package com.te.hibernate.onetoone;

import javax.persistence.*;

public class UnidirectionalMain {

	public static void main(String[] args) {
		Passport passport = new Passport();
		passport.setPassId(2);
		passport.setPassNum("BCDE1234");
		Person person = new Person();
		person.setPId(200);
		person.setPName("Steve");
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
