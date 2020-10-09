package model;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.LocalDateAttributeConverter;
	@Entity
	@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private int id;
	@Column(name = "CUSTOMER_NAME")
	private String name;
	@Column(name = "CELL_NUMBER")
	private String cellNumber;
	@Column(name = "PURCHASE_DATE")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate purchaseDate;
	@Column(name = "CAR_ID")
	private int car;
	
public Customer() {
	
}
public Customer(int id, String name,LocalDate purchaseDate, String cellNumber, int car) {
	this.id = id;
	this.name = name;
	this.cellNumber = cellNumber;
	this.purchaseDate = purchaseDate;
	this.car = car;
}
public Customer( String name, LocalDate purchaseDate,String cellNumber, int car) {
	this.name = name;
	this.cellNumber = cellNumber;
	this.purchaseDate = purchaseDate;
	this.car = car;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCellNumber() {
	return cellNumber;
}
public void setCellNumber(String cellNumber) {
	this.cellNumber = cellNumber;
}
public LocalDate getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(LocalDate purchaseDate) {
	this.purchaseDate = purchaseDate;
}
public int getCar() {
	return car;
}
public void setCar(int car) {
	this.car = car;
}
	
}

	
