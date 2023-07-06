package com.vehicalparking.mapper;

import com.vehicalparking.dto.VehicleDto;
import com.vehicalparking.model.Vehicle;

public class VehicleMapper {

	public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
		VehicleDto vehicleDto = new VehicleDto(vehicle.getVehicleId(), vehicle.getVehicleType(),
				vehicle.getParkingPrice(), vehicle.getVehicleNo(), vehicle.isDeleted());
		return vehicleDto;
	}

	public static Vehicle mapToVehicle(VehicleDto vehicleDto) {
		Vehicle vehicle = new Vehicle(vehicleDto.getVehicleId(), vehicleDto.getVehicleType(),
				vehicleDto.getParkingPrice(), vehicleDto.getVehicleNo(), vehicleDto.isDeleted());
		return vehicle;
	}
}
