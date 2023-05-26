package com.store.storecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.storecar.entity.OwnerPostEntity;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {

}
