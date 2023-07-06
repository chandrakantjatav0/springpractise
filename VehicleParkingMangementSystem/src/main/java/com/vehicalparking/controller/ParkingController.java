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

import com.vehicalparking.dto.ParkingDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.serviceImpl.ParkingSeviceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/parking")
public class ParkingController {
	private ParkingSeviceImpl parkingService;

	@PostMapping("/save")
	public ResponseEntity<ParkingDto> createParking(@RequestBody ParkingDto parkingDto)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingService.createParking(parkingDto), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ParkingDto>> getAllParking() throws ResourceNotFoundException {
		List<ParkingDto> parking = parkingService.getAllParking();
		return new ResponseEntity<>(parking, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ParkingDto> getParkingById(@PathVariable("id") Integer parkingId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingService.getParkingById(parkingId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteParking(@PathVariable("id") Integer parkingId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingService.softDeleteParking(parkingId), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteParking(@PathVariable("id") Integer parkingId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(parkingService.deleteParking(parkingId), HttpStatus.OK);
	}

}
