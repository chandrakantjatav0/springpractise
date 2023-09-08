package com.stockapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.helper.AdminHelper;
import com.stockapplication.model.Admin;
import com.stockapplication.repository.AdminRepository;
import com.stockapplication.request.AdminRequest;
import com.stockapplication.response.AdminResponse;
import com.stockapplication.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private AdminHelper adminHelper;

	@Override
	public java.lang.String addAdmin(AdminRequest adminRequest) throws ResourceNotFoundException {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptPwd 	= bcrypt.encode(adminRequest.getPassword());
		adminRequest.setPassword(encryptPwd);

		Admin admin = adminHelper.adminFromAdminRequest(adminRequest);
		adminRepo.save(admin);
		return  "Admin saved in Database Succcesfully";
	}
	
	@Override
	public java.lang.String authenticateAdmin(AdminRequest adminRequest) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Admin admin = adminRepo.findByUsername(adminRequest.getUsername());

		if (bcrypt.matches(adminRequest.getPassword(), admin.getPassword())) {
			return "Authenticated Customer";
		} else {
			return "Incorrect Password";
		}
	}

	@Override
	public List<AdminResponse> getAllAdmin() {
		List<Admin> list = adminRepo.findAll();
		return list.stream().map(adminHelper::adminResponseFromAdmin).collect(Collectors.toList());
	}

	@Override
	public Admin findByUsername(String username) {
		return adminRepo.findByUsername(username);
	}

}
