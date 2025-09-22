package com.pragma.traceability.domain.api;

import com.pragma.traceability.domain.model.Log;

public interface ILogServicePort {
    void saveLog(Log log);
}
