package com.pragma.traceability.domain.api;

import com.pragma.traceability.application.dto.response.OrderResumeDto;
import com.pragma.traceability.domain.model.EmployeeResume;
import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.domain.model.OrderResume;

import java.util.List;

public interface ILogServicePort {
    void saveLog(Log log);

    List<Log> getOrderLogs(Long idOrder);

    List<OrderResume> getOrderResume(Long idRestaurant);

    List<EmployeeResume> getEmployeeResume(Long idRestaurant);
}
