package com.vehicalparking.mapper;

import com.vehicalparking.dto.VehicleOwnerDto;
import com.vehicalparking.model.VehicleOwner;

public class VehicleOwnerMapper {
	public static VehicleOwnerDto mapToVehicleOwnerDto(VehicleOwner vehicleOwner) {
		VehicleOwnerDto vehicleOwnerDto = new VehicleOwnerDto(vehicleOwner.getOwnerId(), vehicleOwner.getOwnerName(),
				vehicleOwner.getPhoneNo(), vehicleOwner.isDeleted());
		return vehicleOwnerDto;
	}

	public static VehicleOwner mapToVehicleOwner(VehicleOwnerDto vehicleOwnerDto) {
		VehicleOwner vehicleOwner = new VehicleOwner(vehicleOwnerDto.getOwnerId(), vehicleOwnerDto.getOwnerName(),
				vehicleOwnerDto.getPhoneNo(), vehicleOwnerDto.isDeleted());
		return vehicleOwner;
	}
}
