package com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarResponse {

    private String brand;
    private String model;
    private int year;
}
