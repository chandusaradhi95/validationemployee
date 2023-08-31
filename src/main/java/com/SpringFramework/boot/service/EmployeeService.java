package com.SpringFramework.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringFramework.boot.JPA.EmployeeRepo;
import com.SpringFramework.boot.Model.Employee;
import com.SpringFramework.boot.Model.EmployeeResult;

@Service
public class EmployeeService {
	

	@Autowired
	private EmployeeRepo empRepo;
	
	
	public Optional<Employee> saveEmployee(Employee emp) {
		 
		return Optional.of(empRepo.save(emp));


	}
	
	public  EmployeeResult getEmployeeByID(String empid) {
		EmployeeResult employeeResult= new EmployeeResult();
		Optional<Employee> employee= empRepo.findById(empid);
		double cess=0;
		double tax=0;
		Employee emp=new Employee();
			if(!employee.isEmpty()) {
			emp = employee.get();
			int salary = ((Employee) emp).getSalary();
			tax=getTotalTax(salary);
		
			if(salary>2500000) {
		    cess=calulateCess(salary);
			}
		
		}
	employeeResult.setCess(cess);
	employeeResult.setEmployee(emp);
	employeeResult.setTax(tax);
	return employeeResult;
  
  }
	
	private int getTotalTax(int salary) {
		int tax = 0;
		while(salary >250000) {
			if(salary >= 1000000) {
				int x = salary-1000000;
				tax += getTax(x, 0.2);
				salary-=x;
			}
			if(salary >= 5000000) {
				int x = salary-500000;
				tax += getTax(x, 0.1);
				salary-=x;
			}
			if(salary >= 250000) {
				int x = salary-250000;
				tax += getTax(x, 0.05);
				salary-=x;
			}
			
			
		}
		return tax;
	}
	
	private double getTax(int x, double y) {
		return x*y;
	}
	
	private double calulateCess(int salary) {
		return (salary*0.2);
	}
	

}
