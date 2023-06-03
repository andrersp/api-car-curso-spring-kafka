package com.store.storecar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.storecar.entity.CarPostEntity;

public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
    @Query(value = "select id, car_brand, car_model from car_post", nativeQuery = true)
    List<CarPostEntity> listCars();
}
