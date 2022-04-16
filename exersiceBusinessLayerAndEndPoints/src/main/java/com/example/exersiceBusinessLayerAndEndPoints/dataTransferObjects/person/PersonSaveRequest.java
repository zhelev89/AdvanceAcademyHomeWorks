package com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects.person;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class PersonSaveRequest {
    @NotNull(message = "FullName should not be null.")
    private String fullName;

    @NotNull(message = "Age should not be null.")
    private int age;

    @NotNull(message = "Ucn should not be null.")
    private String ucn;
}
