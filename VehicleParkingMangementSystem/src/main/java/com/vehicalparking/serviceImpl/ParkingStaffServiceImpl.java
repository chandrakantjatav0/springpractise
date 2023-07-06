package com.vehicalparking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vehicalparking.dto.ParkingStaffDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.mapper.ParkingStaffMapper;
import com.vehicalparking.model.ParkingStaff;
import com.vehicalparking.repository.ParkingStaffRepository;
import com.vehicalparking.service.ParkingStaffService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParkingStaffServiceImpl implements ParkingStaffService {
	private ParkingStaffRepository parkingStaffRepo;

	@Override
	public ParkingStaffDto createParkingStaff(ParkingStaffDto parkingStaffDto) throws ResourceNotFoundException {
		ParkingStaff parkingStaff = new ParkingStaff();
		if (parkingStaffDto.getStaffId() != null) {
			parkingStaff = this.parkingStaffRepo.findById(parkingStaffDto.getStaffId())
					.orElseThrow(() -> new ResourceNotFoundException("ParkingStaff is not Available"));
		}
		parkingStaff.setStaffName(parkingStaffDto.getStaffName());
		parkingStaff.setDeleted(parkingStaffDto.isDeleted());
		parkingStaffRepo.save(parkingStaff);
		return ParkingStaffMapper.mapToParkingStaffDto(parkingStaff);
	}

	@Override
	public List<ParkingStaffDto> getAllParkingStaff() throws ResourceNotFoundException {
		List<ParkingStaff> parkingStaff = parkingStaffRepo.findAll();
		return parkingStaff.stream().map(ParkingStaffMapper::mapToParkingStaffDto).collect(Collectors.toList());
	}

	@Override
	public ParkingStaffDto getParkingStaffById(Integer id) throws ResourceNotFoundException {
		ParkingStaff parkingStaff = parkingStaffRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ParkingStaff is not Available!.."));
		return ParkingStaffMapper.mapToParkingStaffDto(parkingStaff);
	}

	@Override
	public String softDeleteParkingStaff(Integer id) throws ResourceNotFoundException {
		ParkingStaff parkingStaff = parkingStaffRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking Staff is Not Available!.."));
		parkingStaff.setDeleted(false);
		parkingStaffRepo.save(parkingStaff);
		return "SoftDeleted this ParkingStaff & marked as Fired!..";
	}

	@Override
	public String deleteParkingStaff(Integer id) throws ResourceNotFoundException {
		parkingStaffRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ParkingStaff is Not Available"));
		parkingStaffRepo.deleteById(id);
		return "Parking Staff Fired!..";
	}

}
