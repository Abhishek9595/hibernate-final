package com.te.hibernate.onetomany;

import java.util.*;

import javax.persistence.*;

public class BidirectionalMain {

	public static void main(String[] args) {
		// first Employee
		Employees employees1 = new Employees();
		employees1.setEmployeeId(300);
		employees1.setName("Viv Richards");
		Company company = new Company();
		company.setCId(2);
		company.setCName("IBM");
		employees1.setCompany(company);

		// second Employee
		Employees employees2 = new Employees();
		employees2.setEmployeeId(400);
		employees2.setName("Shane Warne");
		employees2.setCompany(company);

		// ArrayList of employees
		ArrayList<Employees> arrEmployees = new ArrayList<Employees>();
		arrEmployees.add(employees1);
		arrEmployees.add(employees2);
		company.setListEmployees(arrEmployees);

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(company);
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
