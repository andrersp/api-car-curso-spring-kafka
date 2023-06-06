package com.store.storecar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.storecar.entity.OwnerPostEntity;

public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
    Optional<OwnerPostEntity> findFirstByNameOrderByIdDesc(String name);
}
