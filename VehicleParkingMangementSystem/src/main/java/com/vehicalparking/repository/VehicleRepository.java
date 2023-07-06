package com.vehicalparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicalparking.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
