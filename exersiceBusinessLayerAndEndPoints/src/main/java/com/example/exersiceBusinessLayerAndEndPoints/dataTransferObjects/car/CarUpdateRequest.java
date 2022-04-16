package com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CarUpdateRequest {

    @NotNull(message = "Id should not be null.")
    private Long id;
    private String brand;
    private String model;
    private int year;
}
