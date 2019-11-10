package com.mayuri.company.model;

import java.util.Date;
import java.util.Random;

public class Employee {
	
	private int empId;
	private String name;
	private double salary;
	private String email;
	private Date doj;
	private String panCard;
	private String moblie;
	
	
	public Employee(String name, double salary, String email, String panCard, String moblie) {
		super();
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.panCard = panCard;
		this.moblie = moblie;
		doj = new Date();
		empId = new Random().nextInt(100000); 
	}
	
	
	
	public Employee() {
	}



	public int getEmpId() {
		return empId;
	}




	public void setEmpId(int empId) {
		this.empId = empId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public double getSalary() {
		return salary;
	}




	public void setSalary(double salary) {
		this.salary = salary;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Date getDoj() {
		return doj;
	}




	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public String getPanCard() {
		return panCard;
	}




	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}




	public String getMoblie() {
		return moblie;
	}


	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + empId;
		result = prime * result + ((moblie == null) ? 0 : moblie.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((panCard == null) ? 0 : panCard.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empId != other.empId)
			return false;
		if (moblie == null) {
			if (other.moblie != null)
				return false;
		} else if (!moblie.equals(other.moblie))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (panCard == null) {
			if (other.panCard != null)
				return false;
		} else if (!panCard.equals(other.panCard))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", email=" + email + ", doj="
				+ doj + ", panCard=" + panCard + ", moblie=" + moblie + "]";
	}
	
	
	
}
