package com.vehicalparking.service;

import java.util.List;

import com.vehicalparking.dto.ParkingStaffDto;
import com.vehicalparking.exception.ResourceNotFoundException;

public interface ParkingStaffService {
	ParkingStaffDto createParkingStaff(ParkingStaffDto parkingStaffDto) throws ResourceNotFoundException;

	List<ParkingStaffDto> getAllParkingStaff() throws ResourceNotFoundException;

	ParkingStaffDto getParkingStaffById(Integer id) throws ResourceNotFoundException;

	String softDeleteParkingStaff(Integer id) throws ResourceNotFoundException;

	String deleteParkingStaff(Integer id) throws ResourceNotFoundException;

}
