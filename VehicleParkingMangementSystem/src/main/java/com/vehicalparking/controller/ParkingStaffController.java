package com.vehicalparking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicalparking.dto.ParkingStaffDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.serviceImpl.ParkingStaffServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/parkingStaff")
public class ParkingStaffController {
	private ParkingStaffServiceImpl parkingStaffService;

	@PostMapping("/save")
	public ResponseEntity<ParkingStaffDto> createParkingStaff(@RequestBody ParkingStaffDto parkingStaffDto)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingStaffService.createParkingStaff(parkingStaffDto), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ParkingStaffDto>> getAllParkingStaff() throws ResourceNotFoundException {
		List<ParkingStaffDto> parkingDto = parkingStaffService.getAllParkingStaff();
		return new ResponseEntity<>(parkingDto, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ParkingStaffDto> getParkingStaffById(@PathVariable("id") Integer parkingStaffId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingStaffService.getParkingStaffById(parkingStaffId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteParkingStaff(@PathVariable("id") Integer parkingStaffId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingStaffService.softDeleteParkingStaff(parkingStaffId), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteParkingStaff(@PathVariable("id") Integer parkingStaffId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingStaffService.deleteParkingStaff(parkingStaffId), HttpStatus.OK);
	}

}
