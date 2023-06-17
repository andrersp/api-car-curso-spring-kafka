package com.store.storecar.services;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static com.store.storecar.common.CarsContants.CAR_ENTITY;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.store.storecar.dto.CarPostDTO;
import com.store.storecar.repository.CarPostRepository;
import com.store.storecar.service.impl.CarPostServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceCarsTest {

    @InjectMocks
    private CarPostServiceImpl carService;

    @Mock
    private CarPostRepository carRepository;

    @Test
    public void getCar_WithValidId_ReturnCar() {
        when(carRepository.findById(1L)).thenReturn(Optional.of(CAR_ENTITY));
        CarPostDTO sut = carService.getCarDetail(1L);
        Assertions.assertThat(sut.getId()).isEqualTo(CAR_ENTITY.getId());

    }

}
