package com.pragma.traceability.application.handler;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;

public interface ILogHandler {
    void saveLog(SaveLogRequestDto saveLog);
}
