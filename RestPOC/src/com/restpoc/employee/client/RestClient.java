package com.restpoc.employee.client;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.restpoc.employee.domain.Employee;

public class RestClient {

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.setId("1");
		employee.setName("Emp1");
		
		RestTemplate rest = new RestTemplate();
		ResponseEntity<Employee> response = rest.postForEntity(
				"http://localhost:8080/RestPOC/employee", employee,
				Employee.class);
		Employee addedEmployee = response.getBody();
		URI url = response.getHeaders().getLocation();// TODO Auto-generated
														// method stub

	}

}
