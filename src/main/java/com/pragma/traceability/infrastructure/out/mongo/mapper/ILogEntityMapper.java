package com.pragma.traceability.infrastructure.out.mongo.mapper;

import com.pragma.traceability.domain.model.Log;
import com.pragma.traceability.infrastructure.out.mongo.entity.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ILogEntityMapper {
    LogEntity toEntity(Log log);
}
