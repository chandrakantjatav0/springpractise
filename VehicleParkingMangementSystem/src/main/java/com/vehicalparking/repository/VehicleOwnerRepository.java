package com.vehicalparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicalparking.model.VehicleOwner;

public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Integer> {

}
