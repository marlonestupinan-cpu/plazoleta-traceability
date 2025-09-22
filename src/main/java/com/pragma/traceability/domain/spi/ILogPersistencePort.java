package com.pragma.traceability.domain.spi;

import com.pragma.traceability.domain.model.Log;

public interface ILogPersistencePort {
    void saveLog(Log log);
}
