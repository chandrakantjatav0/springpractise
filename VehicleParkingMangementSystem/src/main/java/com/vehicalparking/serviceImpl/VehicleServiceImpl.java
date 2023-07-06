package com.vehicalparking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.vehicalparking.dto.VehicleDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.mapper.VehicleMapper;
import com.vehicalparking.model.Vehicle;
import com.vehicalparking.repository.VehicleRepository;
import com.vehicalparking.service.VehicleService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
	private VehicleRepository vehicelRepo;

	@Override
	public VehicleDto createVehicle(VehicleDto vehicleDto) throws ResourceNotFoundException {
		Vehicle vehicle = new Vehicle();
		if (vehicleDto.getVehicleId() != null) {
			vehicle = this.vehicelRepo.findById(vehicleDto.getVehicleId())
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle is not Available"));
		}
		vehicle.setVehicleType(vehicleDto.getVehicleType());
		vehicle.setVehicleNo(vehicleDto.getVehicleNo());
		vehicle.setParkingPrice(vehicleDto.getParkingPrice());
		vehicle.setDeleted(vehicleDto.isDeleted());
		vehicelRepo.save(vehicle);
		return VehicleMapper.mapToVehicleDto(vehicle);
	}

	@Override
	public List<VehicleDto> getAllVehicle() throws ResourceNotFoundException {
		List<Vehicle> vehicles = vehicelRepo.findAll();
		return vehicles.stream().map(VehicleMapper::mapToVehicleDto).collect(Collectors.toList());
	}

	@Override
	public VehicleDto getVehicleById(Integer id) throws ResourceNotFoundException {
		Vehicle vehicle = vehicelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking is Empty! You can Parked your Vehicle.. "));
		return VehicleMapper.mapToVehicleDto(vehicle);
	}

	@Override
	public String softDeleteVehicle(Integer id) throws ResourceNotFoundException {
		Vehicle vehicle = vehicelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking is Empty! You can Parked your Vehicle.."));
		vehicle.setDeleted(false);
		vehicelRepo.deleteById(id);
		return "soft Deleted = Vehicle is Exited! You can Parked your Vehicle..";
	}

	@Override
	public String deleteVehicle(Integer id) throws ResourceNotFoundException {
		vehicelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Deleted = No Vehicle is there to Exit!.."));
		vehicelRepo.deleteById(id);
		return "Deleted = Vehicle is Exit Successfully!..";
	}

}
