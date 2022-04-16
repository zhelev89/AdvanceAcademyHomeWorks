package com.example.exersiceBusinessLayerAndEndPoints.converters;

import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car.CarResponse;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car.CarSaveRequest;
import com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.car.CarUpdateRequest;
import com.example.exersiceBusinessLayerAndEndPoints.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car convert(CarSaveRequest carSaveRequest) {
        return Car.builder()
                .brand(carSaveRequest.getBrand())
                .model(carSaveRequest.getModel())
                .year(carSaveRequest.getYear())
                .build();
    }

    public CarResponse convert(Car car) {
        return CarResponse.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .build();
    }

    public Car convert(CarUpdateRequest carUpdateRequest) {
        return Car.builder()
                .id(carUpdateRequest.getId())
                .brand(carUpdateRequest.getBrand())
                .model(carUpdateRequest.getModel())
                .year(carUpdateRequest.getYear())
                .build();
    }
}
