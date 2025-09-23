package com.pragma.traceability.domain.usecase;

import com.pragma.traceability.domain.api.ILogServicePort;
import com.pragma.traceability.domain.model.EmployeeResume;
import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.domain.model.OrderResume;
import com.pragma.traceability.domain.model.State;
import com.pragma.traceability.domain.spi.ILogPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LogUseCase implements ILogServicePort {
    private final ILogPersistencePort logPersistencePort;

    @Override
    public void saveLog(Log log) {
        logPersistencePort.saveLog(log);
    }

    @Override
    public List<Log> getOrderLogs(Long idOrder) {
        return logPersistencePort.getOrderLogs(idOrder);
    }

    @Override
    public List<OrderResume> getOrderResume(Long idRestaurant) {
        List<Log> startLogs = logPersistencePort.getAllOrders(idRestaurant, State.PENDING);
        List<Log> endLogs = logPersistencePort.getAllOrders(idRestaurant, State.DELIVERED);

        Map<Long, Log> mapStart = startLogs.stream().collect(Collectors.toMap(Log::getIdOrder, Function.identity()));
        Map<Long, Log> mapEnd = endLogs.stream().collect(Collectors.toMap(Log::getIdOrder, Function.identity()));

        List<OrderResume> resumeOrders = new ArrayList<>();

        mapEnd.forEach((idOrder, log) -> {
            if (!mapStart.containsKey(idOrder)) return;
            resumeOrders.add(OrderResume.builder()
                    .idOrder(idOrder)
                    .start(mapStart.get(idOrder).getDatetime())
                    .end(log.getDatetime())
                    .duration(log.getDatetime() - mapStart.get(idOrder).getDatetime())
                    .build());
        });

        return resumeOrders;
    }

    @Override
    public List<EmployeeResume> getEmployeeResume(Long idRestaurant) {
        List<Log> startLogs = logPersistencePort.getAllOrders(idRestaurant, State.PENDING);
        List<Log> endLogs = logPersistencePort.getAllOrders(idRestaurant, State.DELIVERED);

        Map<Long, Log> mapStart = startLogs.stream().collect(Collectors.toMap(Log::getIdOrder, Function.identity()));
        Map<Long, Log> mapEnd = endLogs.stream().collect(Collectors.toMap(Log::getIdOrder, Function.identity()));

        Map<Long, EmployeeResume> employees = new HashMap<>();

        mapEnd.forEach((idOrder, log) -> {
            if (!mapStart.containsKey(idOrder)) return;
            Log startLog = mapStart.get(idOrder);

            if (employees.containsKey(log.getIdEmployee())) {
                employees.get(log.getIdEmployee())
                        .addTime(log.getDatetime() - startLog.getDatetime());
            }
            else {
                employees.put(log.getIdEmployee(),
                        EmployeeResume.builder()
                                .idEmployee(log.getIdEmployee())
                                .totalTime(log.getDatetime() - startLog.getDatetime())
                                .numberOrders(1)
                                .employeeEmail(log.getEmployeeEmail())
                                .build()
                );
            }
        });

        return employees.values().stream().sorted().collect(Collectors.toList());
    }
}
