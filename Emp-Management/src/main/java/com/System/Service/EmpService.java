package com.System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.System.Entity.Employee;
import com.System.Repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;

	public void addEmp(Employee e) {
		repo.save(e);
	}

	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	public Employee getEmpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmp(int id) {
		repo.deleteById(id);
	}

	public Page<Employee> getEmpByPaginate(int currentPage, int size) {
		PageRequest p = PageRequest.of(currentPage, size);
		return repo.findAll(p);
	}

}
