package com.pragma.traceability.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResume implements Comparable<EmployeeResume>{
    Long idEmployee;
    String employeeEmail;
    Long median;
    Long totalTime;
    Integer numberOrders;

    public void addTime(long time) {
        totalTime += time;
        numberOrders++;
    }

    public Long getMedian() {
        return totalTime / numberOrders;
    }

    @Override
    public int compareTo(EmployeeResume o) {
        return Long.compare(this.getMedian(), o.getMedian());
    }
}
