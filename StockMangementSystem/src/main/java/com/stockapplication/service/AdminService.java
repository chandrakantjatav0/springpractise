package com.stockapplication.service;

import java.util.List;

import com.stockapplication.exception.ResourceNotFoundException;
import com.stockapplication.model.Admin;
import com.stockapplication.request.AdminRequest;
import com.stockapplication.response.AdminResponse;

public interface AdminService {

	String addAdmin(AdminRequest adminRequest) throws ResourceNotFoundException;

	String authenticateAdmin(AdminRequest adminRequest);

	List<AdminResponse> getAllAdmin();

	Admin findByUsername(String username);

}
