package com.store.storecar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storecar.dto.OwnerPostDTO;
import com.store.storecar.entity.OwnerPostEntity;
import com.store.storecar.repository.OwnerPostRepository;
import com.store.storecar.service.OwnerPostService;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwner(OwnerPostDTO ownerPostDTO) {

        OwnerPostEntity ownerPostEntity = mapOwnerDtoToEntity(ownerPostDTO);

        boolean exist = ownerPostRepository.findFirstByNameOrderByIdDesc(ownerPostEntity.getName()).isPresent();

        if (exist) {
            throw new RuntimeException(String.format("%s: Duplicate name", ownerPostEntity.getName()));
        }

        ownerPostRepository.save(ownerPostEntity);

    }

    private OwnerPostEntity mapOwnerDtoToEntity(OwnerPostDTO ownerPost) {

        OwnerPostEntity ownerPostEntity = new OwnerPostEntity();
        ownerPostEntity.setName(ownerPost.getName());
        ownerPostEntity.setContactNumber(ownerPost.getContactNumber());
        ownerPostEntity.setType(ownerPost.getType());
        return ownerPostEntity;

    }

}
