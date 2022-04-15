package com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {

    private String fullName;
    private int age;
    private String ucn;
}
