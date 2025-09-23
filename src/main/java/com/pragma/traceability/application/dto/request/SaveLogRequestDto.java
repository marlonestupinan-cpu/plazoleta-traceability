package com.pragma.traceability.application.dto.request;

import com.pragma.traceability.domain.model.State;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SaveLogRequestDto {
    private State oldState;
    @NotNull
    private State newState;
    @NotNull
    private Long idClient;
    private Long idEmployee;
    @NotNull
    private Long idOrder;
    @NotNull
    private Long idRestaurant;
    @NotNull
    private Long datetime;
    private String employeeEmail;
}
