package com.pragma.traceability.application.dto.response;

import com.pragma.traceability.domain.model.State;
import lombok.Data;

@Data
public class LogResponseDto {
    private String id;
    private State oldState;
    private State newState;
    private Long idClient;
    private Long idEmployee;
    private Long idOrder;
    private Long idRestaurant;
    private Long datetime;
    private String employeeEmail;
}
