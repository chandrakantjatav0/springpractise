package com.vehicalparking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.vehicalparking.dto.ParkingDto;
import com.vehicalparking.exception.ResourceNotFoundException;
import com.vehicalparking.mapper.ParkingMapper;
import com.vehicalparking.model.Parking;
import com.vehicalparking.repository.ParkingRepository;
import com.vehicalparking.service.ParkingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParkingSeviceImpl implements ParkingService {
	private ParkingRepository parkingRepo;

	@Override
	public ParkingDto createParking(ParkingDto parkingDto) throws ResourceNotFoundException {
		Parking parking = new Parking();
		if (parkingDto.getParkingId() != null) {
			parking = this.parkingRepo.findById(parkingDto.getParkingId())
					.orElseThrow(() -> new ResourceNotFoundException("Parking is Not Available!.."));
		}
		parking.setParkingArea(parkingDto.getParkingArea());
		parking.setParkingAlottaion(parkingDto.getParkingAlottaion());
		parking.setDeleted(parkingDto.isDeleted());
		parkingRepo.save(parking);
		return ParkingMapper.mapToParkingDto(parking);
	}

	@Override
	public List<ParkingDto> getAllParking() throws ResourceNotFoundException {
		List<Parking> parking = parkingRepo.findAll();
		return parking.stream().map(ParkingMapper::mapToParkingDto).collect(Collectors.toList());
	}

	@Override
	public ParkingDto getParkingById(Integer id) throws ResourceNotFoundException {
		Parking parking = parkingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking is Not Available!.."));
		return ParkingMapper.mapToParkingDto(parking);
	}

	@Override
	public String softDeleteParking(Integer id) throws ResourceNotFoundException {
		Parking parking = parkingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking is Not Available!.."));
		parking.setDeleted(false);
		parkingRepo.save(parking);
		return "Soft Deleted this Parking...";
	}

	@Override
	public String deleteParking(Integer id) throws ResourceNotFoundException {
		parkingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Parking is Not Available"));
		parkingRepo.deleteById(id);
		return "Parking is  Deleted Successfully...";
	}

}