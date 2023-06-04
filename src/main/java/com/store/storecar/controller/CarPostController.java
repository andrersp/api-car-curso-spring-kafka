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
import com.store.storecar.dto.ResumeCarDTO;
import com.store.storecar.service.CarPostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veiculos", description = "Endpoint para consulta e cadastro veiculos")
@RestController
@RequestMapping("/cars")
public class CarPostController {
    @Autowired
    private CarPostService carPostService;

    @GetMapping("")
    public ResponseEntity<List<ResumeCarDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.getCarSales());

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostService.changeCarSale(carPostDTO, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete um veiculos", description = "Endpoint para deletar um veiculo", responses = @ApiResponse(responseCode = "204", content = @Content(schema = @Schema(hidden = true))))
    public ResponseEntity<?> deleteCarSale(@PathVariable("id") String id) {
        carPostService.removeCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
