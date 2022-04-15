package com.example.exersiceBusinessLayerAndEndPoints.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateRequest {

    @NotNull(message = "Id should not be null!")
    private Long id;

    @NotNull(message = "FullName should not be null.")
    private String fullName;

    @NotNull(message = "Age should not be null.")
    private int age;

    @NotNull(message = "UCN should not be null.")
    private String ucn;
}
