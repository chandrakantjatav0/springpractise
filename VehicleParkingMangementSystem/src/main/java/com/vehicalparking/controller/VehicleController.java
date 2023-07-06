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

import com.vehicalparking.dto.VehicleDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.serviceImpl.VehicleServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	private VehicleServiceImpl vehicleService;

	@PostMapping("/save")
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto), HttpStatus.CREATED);
	}

	@GetMapping("getAll")
	public ResponseEntity<List<VehicleDto>> getAllVehicle() throws ResourceNotFoundException {
		List<VehicleDto> vehicleDto = vehicleService.getAllVehicle();
		return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Integer vehicleId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleService.getVehicleById(vehicleId), HttpStatus.OK);
	}

	@DeleteMapping("/softDelete/{id}")
	public ResponseEntity<String> softDeleteVehicle(@PathVariable("id") Integer vehicleId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleService.softDeleteVehicle(vehicleId), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") Integer vehicleId)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(vehicleService.deleteVehicle(vehicleId), HttpStatus.OK);
	}

}
