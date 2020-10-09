package controller;



import java.time.LocalDate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Customer;



public class CustomerHelper {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebCarDealershipIanWetzler");
	EntityManager em = emf.createEntityManager();
	public CustomerHelper(EntityManager em) {
		this.em = em;
	}
	public Customer createCustomer(String name,LocalDate purchaseDate, String cellNumber,int tempId) {
		Customer customer = new Customer(name,purchaseDate, cellNumber,tempId);
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.persist(customer);
		 return customer;
	}
		
	

	public void deleteCustomer(Customer toDelete) {
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.id = :selectedId and li.name = :selectedName and li.cellNumber = :selectedCellNumber and li.purchaseDate = :selectedPurchaseDate and li.car =  :selectedCar", Customer.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedCellNumber", toDelete.getCellNumber());
		typedQuery.setParameter("selectedPurchaseDate", toDelete.getPurchaseDate());
		typedQuery.setParameter("selectedCar", toDelete.getCar());
		typedQuery.setMaxResults(1);
		Customer result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public Customer findCustomer(int id) {
		return em.find(Customer.class, id);
	}

	
public List<Customer> viewAllCustomers() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Customer> allCustomer = em.createQuery("SELECT i FROM Customer i").getResultList();
	return	allCustomer;
	}
	public Customer searchForCustomerById(int idToEdit) {
		// TODO Auto-generated method stub
		Customer found = em.find(Customer.class,idToEdit);
		return	found;
	}
}
