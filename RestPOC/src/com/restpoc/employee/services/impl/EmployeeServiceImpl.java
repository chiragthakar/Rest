/**
 * 
 */
package com.restpoc.employee.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.restpoc.employee.domain.Employee;
import com.restpoc.employee.services.EmployeeService;

/**
 * @author sinchh
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employees = new ArrayList<Employee>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restpoc.employee.services.EmployeeService#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.restpoc.employee.services.EmployeeService#getEmployee(java.lang.String
	 * )
	 */
	@Override
	public Employee getEmployee(String employeeId) {
		List<Employee> allEmployees = getAllEmployees();
		Employee employee = null;
		for (Employee emp : allEmployees) {
			if (emp.getId().equals(employeeId)) {
				employee = emp;
				break;
			}
		}
		return employee;
	}

	private List<Employee> createDummyEmployees() {

		List<Employee> employees = new ArrayList<Employee>();

		Employee emp1 = new Employee();
		emp1.setId("1");
		emp1.setName("Emp1");

		Employee emp2 = new Employee();
		emp2.setId("2");
		emp2.setName("Emp2");

		employees.add(emp1);
		employees.add(emp2);

		return employees;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		List<Employee> allEmployees = getAllEmployees();
		allEmployees.add(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		List<Employee> allEmployees = getAllEmployees();
		for (Employee emp : allEmployees) {

			if (emp.getId().equals(employee.getId())) {
				int index = allEmployees.indexOf(emp);
				allEmployees.set(index, employee);
				break;
			}
		}
		return employee;
	}

	@Override
	public void deleteEmployee(String employeeId) {
		List<Employee> allEmployees = getAllEmployees();
		for (Employee emp : allEmployees) {

			if (emp.getId().equals(employeeId)) {
				int index = allEmployees.indexOf(emp);
				allEmployees.remove(index);
				break;
			}
		}

	}

}
