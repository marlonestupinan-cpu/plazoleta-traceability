package com.pragma.traceability.infrastructure.out.mongo.adapter;

import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.domain.spi.ILogPersistencePort;
import com.pragma.traceability.infrastructure.out.mongo.mapper.ILogEntityMapper;
import com.pragma.traceability.infrastructure.out.mongo.repository.ILogRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogMongoAdapter implements ILogPersistencePort {
    private final ILogRepository logRepository;
    private final ILogEntityMapper logMapper;
    @Override
    public void saveLog(Log log) {
        logRepository.save(logMapper.toEntity(log));
    }
}
