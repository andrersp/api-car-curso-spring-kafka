package com.store.storecar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude
public class ResumeCarDTO {
    private Long id;
    private String brand;
    private String model;

    public ResumeCarDTO(Long id, String brand, String model) {

        this.id = id;

        this.brand = brand;

        this.model = model;
    }

    @Schema(example = "1")
    public Long getId() {
        return id;
    }

    @Schema(example = "GM")
    public String getBrand() {
        return brand;
    }

    @Schema(example = "Corsa")
    public String getModel() {
        return model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
