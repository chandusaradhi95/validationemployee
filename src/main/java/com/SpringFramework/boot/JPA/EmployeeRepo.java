package com.SpringFramework.boot.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringFramework.boot.Model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
