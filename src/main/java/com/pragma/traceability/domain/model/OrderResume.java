package com.pragma.traceability.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResume {
    private Long idOrder;
    private Long start;
    private Long end;
    private Long duration;

}
