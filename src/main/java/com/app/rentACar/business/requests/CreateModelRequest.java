package com.app.rentACar.business.requests;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull
    @Size(min = 3,max = 20)
    private String name;
    @NotNull
    private int brandId;

}
