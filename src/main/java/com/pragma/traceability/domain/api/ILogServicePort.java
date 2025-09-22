package com.pragma.traceability.domain.api;

import com.pragma.traceability.domain.model.Log;

import java.util.List;

public interface ILogServicePort {
    void saveLog(Log log);

    List<Log> getOrderLogs(Long idOrder);
}
