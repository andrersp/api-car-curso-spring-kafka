package com.store.storecar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.storecar.dto.CarPostDTO;
import com.store.storecar.service.CarPostService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veiculos", description = "Endpoint para consulta e cadastro veiculos")
@RestController
@RequestMapping("/sales")
public class CarPostController {
    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.getCarSales());

    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<?> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostService.changeCarSale(carPostDTO, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCarSale(@PathVariable("id") String id) {
        carPostService.removeCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
