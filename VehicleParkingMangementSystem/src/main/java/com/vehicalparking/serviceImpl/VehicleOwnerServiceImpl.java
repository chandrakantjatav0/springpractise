package com.vehicalparking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vehicalparking.dto.VehicleOwnerDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.mapper.VehicleOwnerMapper;
import com.vehicalparking.model.VehicleOwner;
import com.vehicalparking.repository.VehicleOwnerRepository;
import com.vehicalparking.service.VehicleOwnerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleOwnerServiceImpl implements VehicleOwnerService {
	private VehicleOwnerRepository vehicleOwnerRepo;

	@Override
	public VehicleOwnerDto createVehicelOwner(VehicleOwnerDto vehiceOwnerDto) throws ResourceNotFoundException {
		VehicleOwner vehicleOwner = new VehicleOwner();
		if (vehiceOwnerDto.getOwnerId() != null) {
			vehicleOwner = this.vehicleOwnerRepo.findById(vehiceOwnerDto.getOwnerId())
					.orElseThrow(() -> new ResourceNotFoundException("VehicleOwner Is not there!.."));
		}
		vehicleOwner.setOwnerName(vehiceOwnerDto.getOwnerName());
		vehicleOwner.setPhoneNo(vehiceOwnerDto.getPhoneNo());
		vehicleOwner.setDeleted(vehiceOwnerDto.isDeleted());
		vehicleOwnerRepo.save(vehicleOwner);
		return VehicleOwnerMapper.mapToVehicleOwnerDto(vehicleOwner);
	}

	@Override
	public List<VehicleOwnerDto> getAllVehicleOwner() throws ResourceNotFoundException {
		List<VehicleOwner> vehicleOwners = vehicleOwnerRepo.findAll();
		return vehicleOwners.stream().map(VehicleOwnerMapper::mapToVehicleOwnerDto).collect(Collectors.toList());
	}

	@Override
	public VehicleOwnerDto getVehicleOwnerById(Integer id) throws ResourceNotFoundException {
		VehicleOwner vehicleOwner = vehicleOwnerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("VehicleOwnwer is not available"));
		return VehicleOwnerMapper.mapToVehicleOwnerDto(vehicleOwner);
	}

	@Override
	public String softDeleteVehicleOwner(Integer id) throws ResourceNotFoundException {
		VehicleOwner vehicleOwner = vehicleOwnerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("VehicleOwnwer is not available for softDelete."));
		vehicleOwner.setDeleted(false);
		vehicleOwnerRepo.deleteById(id);
		return "SoftDelete = vehicleOwner is Exit from ParkingArea.";
	}

	@Override
	public String deleteVehicleOwner(Integer id) throws ResourceNotFoundException {
		vehicleOwnerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No VehicleOwner is there!.."));
		vehicleOwnerRepo.deleteById(id);
		return "Deleted = VehicleOwner is Exited From ParkingArea...";
	}

}
