package com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CarSaveRequest {

    @NotNull(message = "Brand should not be null.")
    private String brand;

    @NotNull(message = "Model should not be null.")
    private String model;

    @NotNull(message = "Year should not be null.")
    private int year;
}
