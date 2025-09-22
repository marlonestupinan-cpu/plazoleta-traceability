package com.pragma.traceability.domain.spi;

import com.pragma.traceability.domain.model.Log;

import java.util.List;

public interface ILogPersistencePort {
    void saveLog(Log log);

    List<Log> getOrderLogs(Long idOrder);
}
