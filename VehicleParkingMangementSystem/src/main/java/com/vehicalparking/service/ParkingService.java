package com.vehicalparking.service;

import java.util.List;

import com.vehicalparking.dto.ParkingDto;
import com.vehicalparking.exception.ResourceNotFoundException;

public interface ParkingService {
	ParkingDto createParking(ParkingDto parkingDto) throws ResourceNotFoundException;

	List<ParkingDto> getAllParking() throws ResourceNotFoundException;

	ParkingDto getParkingById(Integer id) throws ResourceNotFoundException;

	String softDeleteParking(Integer id) throws ResourceNotFoundException;

	String deleteParking(Integer id) throws ResourceNotFoundException;

}