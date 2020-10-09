package controller;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Car;



public class CarHelper {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebCarDealershipIanWetzler");
	EntityManager em = emf.createEntityManager();
	
	public CarHelper(EntityManager em) {
		this.em = em;
	}
	public Car createCar(int id,String make, String model, int year) {
		EntityManager em = emf.createEntityManager();
		Car car = new Car(id, make,model,year);
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		em.persist(car);
		
		return car;
	}
	public void removeCar(int id) {
		Car car = findCar(id);
		if(car != null) {
			em.remove(car);
			}
		}
	public void editCarIdYear(int id, String entry, int change) {
		Car car = findCar(id);
		if(car != null) {
			if(entry.equalsIgnoreCase("id")) {
				car.setId(change);
				em.persist(car);
			}
			else if(entry.equalsIgnoreCase("Year")) {
				car.setYear(change);
				em.persist(car);
			}
		
	}
	
		
	}
	public void editCarMakeModel(int id, String entry, String change) {
		Car car = findCar(id);
		if(car != null) {
			if(entry.equalsIgnoreCase("make")) {
				car.setMake(change);
				em.persist(car);
			}
			else if(entry.equalsIgnoreCase("model")) {
				car.setModel(change);
				em.persist(car);
			}
		
		}
	}
	public Car findCar(int id) {
		return em.find(Car.class, id);
	}
	public String findAllCars() {
		ArrayList<String>data = new ArrayList<String>();
		em.getTransaction().begin();
		int i = 1;
		while(em.find(Car.class, i) != null) {
			Car car = em.find(Car.class, i);
			data.add( " ID: " + car.getId() + " Make: " + car.getMake() + " Model: " + car.getModel() + " Year: " + car.getYear());
			i++;
			
			
		}
		
		return data.toString();
	
	}
	public List<Car> viewAllCars() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Car> allCars = em.createQuery("SELECT i FROM Car i").getResultList();
	return	allCars;
	}
	public Car searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		Car found = em.find(Car.class,idToEdit);
		return	found;
	}
		
}


