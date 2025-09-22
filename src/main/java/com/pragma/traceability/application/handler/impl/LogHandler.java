package com.pragma.traceability.application.handler.impl;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.application.dto.response.LogResponseDto;
import com.pragma.traceability.application.handler.ILogHandler;
import com.pragma.traceability.application.mapper.ILogResponseMapper;
import com.pragma.traceability.application.mapper.ISaveLogRequestMapper;
import com.pragma.traceability.domain.api.ILogServicePort;
import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.infrastructure.exception.ForbiddenAccessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LogHandler implements ILogHandler {
    private final ILogServicePort logServicePort;
    private final ISaveLogRequestMapper saveLogRequestMapper;
    private final ILogResponseMapper logResponseMapper;
    @Override
    public void saveLog(SaveLogRequestDto saveLog) {
        logServicePort.saveLog(saveLogRequestMapper.toLog(saveLog));
    }

    @Override
    public List<LogResponseDto> getOrderLogs(Long idOrder, Long idClient) {
        List<Log> logs = logServicePort.getOrderLogs(idOrder);

        if (!logs.isEmpty() && !logs.get(0).getIdClient().equals(idClient)) {
            throw new ForbiddenAccessException();
        }

        return logResponseMapper.toResponseList(logs);
    }
}
