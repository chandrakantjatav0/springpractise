package com.vehicalparking.service;

import java.util.List;

import com.vehicalparking.dto.VehicleDto;
import com.vehicalparking.exception.ResourceNotFoundException;

public interface VehicleService {
	VehicleDto createVehicle(VehicleDto vehicleDto) throws ResourceNotFoundException;

	List<VehicleDto> getAllVehicle() throws ResourceNotFoundException;

	VehicleDto getVehicleById(Integer id) throws ResourceNotFoundException;

	String softDeleteVehicle(Integer id) throws ResourceNotFoundException;

	String deleteVehicle(Integer id) throws ResourceNotFoundException;

}