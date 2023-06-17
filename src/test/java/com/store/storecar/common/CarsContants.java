package com.store.storecar.common;

import java.util.Date;

import com.store.storecar.dto.CarPostDTO;
import com.store.storecar.entity.CarPostEntity;
import com.store.storecar.entity.OwnerPostEntity;

public class CarsContants {

    public static final CarPostDTO CAR_DTO = CarPostDTO.builder()
            .model("modelo")
            .brand("marcar")
            .price(2.00)
            .description("descricao")
            .engineVersion("novo")
            .build();
    private static final OwnerPostEntity OWNER_ENTITY = new OwnerPostEntity(1L, "nome", "Comercial", "1234565789");
    public static final CarPostEntity CAR_ENTITY = new CarPostEntity(1L, "model", "brand", 2.00, "description",
            "engineBersion", "City", String.valueOf(new Date()), "contact", OWNER_ENTITY);

}
