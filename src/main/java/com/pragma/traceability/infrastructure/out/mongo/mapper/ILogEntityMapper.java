package com.pragma.traceability.infrastructure.out.mongo.mapper;

import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.infrastructure.out.mongo.entity.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ILogEntityMapper {
    LogEntity toEntity(Log log);
    Log toLog(LogEntity entity);
    List<Log> toLogList(List<LogEntity> entities);
}
