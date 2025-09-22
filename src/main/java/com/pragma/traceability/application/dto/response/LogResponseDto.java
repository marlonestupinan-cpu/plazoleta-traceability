package com.pragma.traceability.application.dto.response;

import com.pragma.traceability.domain.model.State;
import lombok.Data;

@Data
public class LogResponseDto {
    private String id;
    private State state;
    private Long idClient;
    private Long idEmployee;
    private Long idOrder;
    private Long idRestaurant;
    private Long datetime;
}
