/**
 * 
 */
package com.restpoc.employee.services;

import java.util.List;

import com.restpoc.employee.domain.Employee;

/**
 * @author sinchh
 *
 */
public interface EmployeeService {

	public List<Employee> getAllEmployees() ;
	
	public Employee getEmployee(String employeeId) ;
	
	public Employee addEmployee(Employee employee) ;
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(String employeeId) ;
}
