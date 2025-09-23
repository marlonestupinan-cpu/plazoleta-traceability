package com.pragma.traceability.domain.spi;

import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.domain.model.State;

import java.util.List;

public interface ILogPersistencePort {
    void saveLog(Log log);

    List<Log> getOrderLogs(Long idOrder);

    List<Log> getAllOrders(Long idRestaurant, State state);
}
