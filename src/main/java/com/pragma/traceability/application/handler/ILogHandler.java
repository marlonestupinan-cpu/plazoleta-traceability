package com.pragma.traceability.application.handler;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.application.dto.response.LogResponseDto;

import java.util.List;

public interface ILogHandler {
    void saveLog(SaveLogRequestDto saveLog);

    List<LogResponseDto> getOrderLogs(Long idOrder, Long idClient);
}
