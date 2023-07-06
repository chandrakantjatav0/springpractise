package com.vehicalparking.service;

import java.util.List;

import com.vehicalparking.dto.VehicleOwnerDto;
import com.vehicalparking.exception.ResourceNotFoundException;

public interface VehicleOwnerService {
	VehicleOwnerDto createVehicelOwner(VehicleOwnerDto vehicleOwnerDto) throws ResourceNotFoundException;

	List<VehicleOwnerDto> getAllVehicleOwner() throws ResourceNotFoundException;

	VehicleOwnerDto getVehicleOwnerById(Integer id) throws ResourceNotFoundException;

	String softDeleteVehicleOwner(Integer id) throws ResourceNotFoundException;

	String deleteVehicleOwner(Integer id) throws ResourceNotFoundException;

}
