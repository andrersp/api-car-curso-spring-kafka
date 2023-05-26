package com.store.storecar.service;

import org.springframework.stereotype.Service;

import com.store.storecar.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {
    void createOwner(OwnerPostDTO OwnerPostDTO);
}
