package com.codemyth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemyth.model.Employee;
import com.codemyth.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/employees")
	public String CreateNewEmployee(@RequestBody Employee employee) {

		// Employee employee = new Employee();
//		employee.setAge(employeeRequest.getAge());
//		employee.setEmpid(employeeRequest.getEmpid());
//		employee.setCity(employeeRequest.getCity());
//		employee.setName(employeeRequest.getName());
//		employee.setSalary(employeeRequest.getSalary());

		employeeRepository.save(employee);
		return "Employee Created in Database";
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> emplist = new ArrayList<>();
		employeeRepository.findAll().forEach(emplist::add);
		List<Employee> findAll = employeeRepository.findAll();
		return new ResponseEntity<>(emplist, HttpStatus.OK);
	}

	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") long empid) {
		Optional<Employee> emp = employeeRepository.findById(empid);
		if (emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(empid);
		if (emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setAge(employee.getAge());
			existEmp.setCity(employee.getCity());
			existEmp.setName(employee.getName());
			existEmp.setSalary(employee.getSalary());
			employeeRepository.save(existEmp);
			return "Employee Details against Id  " + empid + "  Updated";
		} else {
			return "Employee Details Does not exists for empid  " + empid;
		}
	}

	@DeleteMapping("/employees/{empid}")
	public String deleteEmployeeByEmpId(@PathVariable long empid) {
		employeeRepository.deleteById(empid);
		return "Employee Deleted Successfully";
	}

	@DeleteMapping("/employees")
	public String deleteAllEmployee() {
		employeeRepository.deleteAll();
		return "All Employees Deleted Sucessfully...";
	}
}
