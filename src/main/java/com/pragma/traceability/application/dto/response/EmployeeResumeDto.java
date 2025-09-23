package com.pragma.traceability.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResumeDto {
    Long idEmployee;
    String employeeEmail;
    Long median;
    Integer numberOrders;
}
