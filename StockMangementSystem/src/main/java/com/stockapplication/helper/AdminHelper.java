package com.stockapplication.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Admin;
import com.stockapplication.repository.AdminRepository;
import com.stockapplication.request.AdminRequest;
import com.stockapplication.response.AdminResponse;

@Component
public class AdminHelper {
	@Autowired
	private AdminRepository adminRepo;

	public Admin adminFromAdminRequest(AdminRequest adminRequest) throws ResourceNotFoundException {
		Admin admin = new Admin();
		if (adminRequest.getId() != null) {
			admin = this.adminRepo.findById(adminRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No Admin Foundednwith this Id!"));
		}
		admin.setName(adminRequest.getName());
		admin.setUsername(adminRequest.getUsername());
		admin.setPassword(adminRequest.getPassword());
		return admin;
	}

	public AdminResponse adminResponseFromAdmin(Admin admin) {
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.setId(admin.getId());
		adminResponse.setName(admin.getName());
		adminResponse.setUsername(admin.getUsername());
		adminResponse.setPassword(admin.getPassword());
		return adminResponse;

	}

}
