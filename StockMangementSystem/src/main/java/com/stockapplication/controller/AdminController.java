package com.stockapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.request.AdminRequest;
import com.stockapplication.response.AdminResponse;
import com.stockapplication.service.impl.AdminServiceImpl;

@RestController
@RequestMapping("/api/stocknew/admin")
public class AdminController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@PostMapping("/save")
	public String addAdmin(@RequestBody AdminRequest adminRequest) throws ResourceNotFoundException {
		return adminServiceImpl.addAdmin(adminRequest);
	}

	@PostMapping("/authenticateAdmin")
	public String authenticateAdmin(@RequestBody AdminRequest adminRequest) {
		return adminServiceImpl.authenticateAdmin(adminRequest);
	}

	@GetMapping("/getAll")
	public List<AdminResponse> getAllAdmin() {
		return adminServiceImpl.getAllAdmin();
	}
}
