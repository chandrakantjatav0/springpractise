package com.vehicalparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicalparking.model.ParkingStaff;

public interface ParkingStaffRepository extends JpaRepository<ParkingStaff, Integer> {

}
