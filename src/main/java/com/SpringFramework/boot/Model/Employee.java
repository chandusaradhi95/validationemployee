package com.SpringFramework.boot.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;




@Validated
@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@NotNull(message="employee id should ot be null")
	private String employeeId;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@Email
	private String email;
	
	@ElementCollection
    @CollectionTable(name="phoneNumbers")
	@Pattern(regexp="(^$|[0-9]{10})")
//	@Size(min = 10,max=10, message = "phone number is not valid")
	private List<String> phoneNumber = new ArrayList<String>();
	
	@NotNull
	private String doj;
	
	@NotNull(message="please enter salary")
	private int salary;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		if(this.phoneNumber==null) {
			this.phoneNumber= new ArrayList<String>();
		}
		String temp = "";
		for(String t : phoneNumber) {
			temp += "," + t;
		}
		return temp;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String dOJ) {
		this.doj = dOJ;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	

	

	

}
