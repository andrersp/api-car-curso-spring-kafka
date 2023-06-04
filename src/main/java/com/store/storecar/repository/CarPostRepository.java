package com.store.storecar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.storecar.dto.ResumeCarDTO;
import com.store.storecar.entity.CarPostEntity;

public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
    @Query("SELECT new com.store.storecar.dto.ResumeCarDTO (id, brand, model) FROM CarPostEntity car")
    List<ResumeCarDTO> listCars();
}
