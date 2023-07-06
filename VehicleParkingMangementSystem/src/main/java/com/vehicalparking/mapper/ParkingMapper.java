package com.vehicalparking.mapper;

import com.vehicalparking.dto.ParkingDto;
import com.vehicalparking.model.Parking;

public class ParkingMapper {

	public static ParkingDto mapToParkingDto(Parking parking) {
		ParkingDto parkingDto = new ParkingDto(parking.getParkingId(), parking.getParkingArea(),
				parking.getParkingAlottaion(), parking.isDeleted());
		return parkingDto;
	}

	public static Parking mapToParking(ParkingDto parkingDto) {
		Parking parking = new Parking(parkingDto.getParkingId(), parkingDto.getParkingArea(),
				parkingDto.getParkingAlottaion(), parkingDto.isDeleted());
		return parking;
	}
}