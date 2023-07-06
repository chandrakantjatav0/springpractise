package com.vehicalparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicalparking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {

}