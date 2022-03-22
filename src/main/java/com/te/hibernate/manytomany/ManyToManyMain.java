package com.te.hibernate.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManyToManyMain {

	public static void main(String[] args) {
		// first doctor
		Doctor doctor1 = new Doctor();
		doctor1.setDId(1);
		doctor1.setName("Sakshi");

		// second doctor
		Doctor doctor2 = new Doctor();
		doctor2.setDId(2);
		doctor2.setName("Sumedha");

		// first patient
		Patient patient1 = new Patient();
		patient1.setPId(100);
		patient1.setPName("Aditi");

		// second patient
		Patient patient2 = new Patient();
		patient2.setPId(200);
		patient2.setPName("Sushmitha");

		// list of doctors
		ArrayList<Doctor> listDoctors = new ArrayList<Doctor>();
		listDoctors.add(doctor1);
		listDoctors.add(doctor2);

		// list of patients
		ArrayList<Patient> listPatients = new ArrayList<Patient>();
		listPatients.add(patient1);
		listPatients.add(patient2);

		patient1.setListDoctors(listDoctors);
		patient2.setListDoctors(listDoctors);

		doctor1.setListPatients(listPatients);
		doctor2.setListPatients(listPatients);

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("hib");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(doctor1);
			manager.persist(doctor2);
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
