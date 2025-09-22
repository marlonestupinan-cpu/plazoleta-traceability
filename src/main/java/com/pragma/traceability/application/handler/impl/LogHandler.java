package com.pragma.traceability.application.handler.impl;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.application.handler.ILogHandler;
import com.pragma.traceability.application.mapper.ISaveLogRequestMapper;
import com.pragma.traceability.domain.api.ILogServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LogHandler implements ILogHandler {
    private final ILogServicePort logServicePort;
    private final ISaveLogRequestMapper saveLogRequestMapper;
    @Override
    public void saveLog(SaveLogRequestDto saveLog) {
        logServicePort.saveLog(saveLogRequestMapper.toLog(saveLog));
    }
}
