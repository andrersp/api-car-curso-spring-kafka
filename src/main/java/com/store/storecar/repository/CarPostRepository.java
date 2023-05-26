package com.store.storecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storecar.entity.CarPostEntity;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {

}
