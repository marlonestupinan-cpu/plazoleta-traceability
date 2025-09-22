package com.pragma.traceability.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Long id;
    private State state;
    private Long idClient;
    private Long idEmployee;
    private Long idOrder;
    private Long idRestaurant;
    private Long datetime;
}
