package com.pragma.traceability.application.handler;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.application.dto.response.EmployeeResumeDto;
import com.pragma.traceability.application.dto.response.LogResponseDto;
import com.pragma.traceability.application.dto.response.OrderResumeDto;

import java.util.List;

public interface ILogHandler {
    void saveLog(SaveLogRequestDto saveLog);

    List<LogResponseDto> getOrderLogs(Long idOrder, Long idClient);

    List<OrderResumeDto> getOrderResume(Long idRestaurant);

    List<EmployeeResumeDto> getEmployeeResume(Long idRestaurant);
}
