package com.pragma.traceability.infrastructure.out.mongo.adapter;

import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.domain.model.State;
import com.pragma.traceability.domain.spi.ILogPersistencePort;
import com.pragma.traceability.infrastructure.out.mongo.mapper.ILogEntityMapper;
import com.pragma.traceability.infrastructure.out.mongo.repository.ILogRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LogMongoAdapter implements ILogPersistencePort {
    private final ILogRepository logRepository;
    private final ILogEntityMapper logMapper;

    @Override
    public void saveLog(Log log) {
        logRepository.save(logMapper.toEntity(log));
    }

    @Override
    public List<Log> getOrderLogs(Long idOrder) {
        return logMapper.toLogList(
                logRepository.findAllByIdOrderOrderByDatetimeAsc(idOrder)
        );
    }

    @Override
    public List<Log> getAllOrders(Long idRestaurant, State state) {
        return logMapper.toLogList(
                logRepository.findAllByIdRestaurantAndNewState(idRestaurant, state)
        );
    }
}
