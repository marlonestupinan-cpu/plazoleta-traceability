package com.pragma.traceability.application.dto.response;

import lombok.Data;

@Data
public class OrderResumeDto {
    private Long idOrder;
    private Long start;
    private Long end;
    private Long duration;
}
