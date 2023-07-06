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

import com.vehicalparking.dto.VehicleOwnerDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.serviceImpl.VehicleOwnerServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vehicleOwner")
public class VehicleOwnerController {
	private VehicleOwnerServiceImpl vehicleOwnerService;

	@PostMapping("/save")
	public ResponseEntity<VehicleOwnerDto> createVehicleOwner(@RequestBody VehicleOwnerDto vehicleOwnerDto)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleOwnerService.createVehicelOwner(vehicleOwnerDto), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<VehicleOwnerDto>> getAllVehicleOwner() throws ResourceNotFoundException {
		List<VehicleOwnerDto> vehicleOwnerDto = vehicleOwnerService.getAllVehicleOwner();
		return new ResponseEntity<>(vehicleOwnerDto, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<VehicleOwnerDto> getVehicleOwnerById(@PathVariable("id") Integer vehicleOwnerId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleOwnerService.getVehicleOwnerById(vehicleOwnerId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteVehicleOwner(@PathVariable("id") Integer vehicleOwnerId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleOwnerService.softDeleteVehicleOwner(vehicleOwnerId), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVehicleOwner(@PathVariable("id") Integer vehicleOwnerId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleOwnerService.deleteVehicleOwner(vehicleOwnerId), HttpStatus.OK);
	}
}
