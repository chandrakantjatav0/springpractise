package com.vehicalparking.mapper;

import com.vehicalparking.dto.ParkingStaffDto;
import com.vehicalparking.model.ParkingStaff;

public class ParkingStaffMapper {
	public static ParkingStaffDto mapToParkingStaffDto(ParkingStaff parkingStaff) {
		ParkingStaffDto parkingStaffDto = new ParkingStaffDto(parkingStaff.getStaffId(), parkingStaff.getStaffName(),
				parkingStaff.isDeleted());
		return parkingStaffDto;
	}

	public static ParkingStaff mapToParkingStaff(ParkingStaffDto parkingStaffDto) {
		ParkingStaff parkingStaff = new ParkingStaff(parkingStaffDto.getStaffId(), parkingStaffDto.getStaffName(),
				parkingStaffDto.isDeleted());
		return parkingStaff;
	}

}
