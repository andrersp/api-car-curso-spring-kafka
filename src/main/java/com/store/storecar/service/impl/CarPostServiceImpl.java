package com.store.storecar.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storecar.dto.CarPostDTO;
import com.store.storecar.entity.CarPostEntity;
import com.store.storecar.repository.CarPostRepository;
import com.store.storecar.repository.OwnerPostRepository;
import com.store.storecar.service.CarPostService;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {

        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);

    }

    @Override
    public List<CarPostDTO> getCarSales() {

        List<CarPostDTO> listCarsSales = new ArrayList<>();

        carPostRepository.findAll().forEach(car -> {
            listCarsSales.add(mapCarEntityToDTO(car));
        });

        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postID) {

        carPostRepository.findById(postID).ifPresentOrElse(car -> {
            car.setDescription(carPostDTO.getDescription());
            car.setContact(carPostDTO.getContact());
            car.setPrice(carPostDTO.getPrice());
            car.setBrand(carPostDTO.getBrand());
            car.setEngineVersion(carPostDTO.getEngineVersion());
            car.setModel(carPostDTO.getModel());
            carPostRepository.save(car);
        }, () -> {
            throw new NoSuchElementException();
        }

        );

    }

    @Override
    public void removeCarSale(Long postID) {

        carPostRepository.deleteById(postID);

    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity) {

        return CarPostDTO.builder()
                .id(carPostEntity.getId())
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .price(carPostEntity.getPrice())
                .ownerType(carPostEntity.getOwnerPost().getType())
                .build();

    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPost) {
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPost.getOwnerId()).ifPresentOrElse(owner -> {
            carPostEntity.setOwnerPost(owner);
            carPostEntity.setContact(owner.getContactNumber());
        }, () -> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPost.getModel());
        carPostEntity.setBrand(carPost.getBrand());
        carPostEntity.setPrice(carPost.getPrice());
        carPostEntity.setCity(carPost.getCity());
        carPostEntity.setDescription(carPost.getDescription());
        carPostEntity.setEngineVersion(carPost.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;

    }

}
