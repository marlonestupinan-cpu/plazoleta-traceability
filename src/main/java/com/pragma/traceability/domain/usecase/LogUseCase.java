package com.pragma.traceability.domain.usecase;

import com.pragma.traceability.domain.api.ILogServicePort;
import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.domain.spi.ILogPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogUseCase implements ILogServicePort {
    private final ILogPersistencePort logPersistencePort;
    @Override
    public void saveLog(Log log) {
        logPersistencePort.saveLog(log);
    }
}
