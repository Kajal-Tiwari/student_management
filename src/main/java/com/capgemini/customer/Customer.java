package com.capgemini.customer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Customer")



public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int cId;
 private String cName;
 private long cMnumber;
 public Customer(int cId, String cName, long cMnumber) {
	super();
	this.cId = cId;
	this.cName = cName;
	this.cMnumber = cMnumber;
}
public Customer() {
	super();
}

public int getcId() {
	return cId;
}
public void setcId(int cId) {
	this.cId = cId;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public long getcMnumber() {
	return cMnumber;
}
public void setcMnumber(long cMnumber) {
	this.cMnumber = cMnumber;
}
}
