/**
 * 
 */
package com.restpoc.employee.mvc;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restpoc.employee.domain.Employee;
import com.restpoc.employee.services.EmployeeService;

/**
 * @author sinchh
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Inject
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Employee> geAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee geEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Employee addEmployee(@RequestBody Employee employee,
			HttpServletResponse httpServletResponse) {
		Employee addedEmployee = employeeService.addEmployee(employee);
		httpServletResponse.setHeader("Location",
				"/employee/" + employee.getId());
		return addedEmployee;
	}

	@RequestMapping(method = RequestMethod.PUT, headers = { "Accept=application/json" })
	public @ResponseBody Employee updateEmployee(
			@RequestBody Employee employee,
			HttpServletResponse httpServletResponse) {
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		httpServletResponse.setHeader("Location",
				"/employee/" + employee.getId());
		return updatedEmployee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
	}
}
