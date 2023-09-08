package com.stockapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stockapplication.model.AdminStock;


public interface AdminStockRepository extends JpaRepository<AdminStock, Integer> {

	AdminStock findByProductId(Integer productid);

	@Query("Select as from AdminStock as where as.product.id = :productid And as.admin.id = :adminstockId ")
	AdminStock findByProductIdandAdminId(Integer productid, Integer adminstockId);

}
