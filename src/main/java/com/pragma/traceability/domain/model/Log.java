package com.pragma.traceability.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
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
