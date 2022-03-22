package com.te.hibernate.onetomany;

import javax.persistence.*;

public class UnidirectionalMain {

	public static void main(String[] args) {
		// first employee
		Employees employees1 = new Employees();
		employees1.setEmployeeId(100);
		employees1.setName("Dravid");
		Company company = new Company();
		company.setCId(1);
		company.setCName("Google");
		employees1.setCompany(company);

		// second employee
		Employees employees2 = new Employees();
		employees2.setEmployeeId(200);
		employees2.setName("Dhoni");
		employees2.setCompany(company);

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employees1);
			manager.persist(employees2);
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
