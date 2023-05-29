package com.store.storecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.storecar.entity.CarPostEntity;

public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {

}
