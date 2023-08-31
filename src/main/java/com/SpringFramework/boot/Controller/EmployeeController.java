package com.SpringFramework.boot.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringFramework.boot.Model.Employee;
import com.SpringFramework.boot.Model.EmployeeResponse;
import com.SpringFramework.boot.Model.EmployeeResult;
import com.SpringFramework.boot.Model.ErrorDetails;
import com.SpringFramework.boot.Model.ResponseStatus;
import com.SpringFramework.boot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmp")
	public String saveEmployee(@RequestBody @Valid Employee emp){
	
		Optional<Employee> o = employeeService.saveEmployee(emp);
		
		if(o.isEmpty()) {
			return "save Failed";
		}
		return "Success";
	}
	
	@GetMapping("/getTax")
	public EmployeeResponse getEmployee(@RequestParam(name="empid", required = false) String empid ) {
		EmployeeResponse response;
		if(empid==null || empid.isBlank()) {
			response =  new EmployeeResponse();
			response.setResponseStatus(new ResponseStatus());
			response.getResponseStatus().setStatus("Failed");
			response.getResponseStatus().setStatusCode("900");
			response.getResponseStatus().setErrorDetails(new ErrorDetails("EmpId is null", "404"));
			return response;
		}
	 EmployeeResult empResult = employeeService.getEmployeeByID(empid);
	 return new EmployeeResponse();
	}

}
