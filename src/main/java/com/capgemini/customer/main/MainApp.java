package com.capgemini.customer.main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.capgemini.customer.Customer;

public class MainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");     //database
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		// em.getTransaction().begin();

		Customer customer = new Customer();
		//customer.setcId(101);
		customer.setcName("Aahu");
		customer.setcMnumber(98798763);

		Customer customer1 = new Customer();
		//customer1.setcId(102);
		customer1.setcName("Varun");
		customer1.setcMnumber(887626282);

		em.persist(customer);
		em.persist(customer1);
		transaction.commit();
		// em.getTransaction().commit();
		em.close();
	}

}
