package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.domain.model.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISaveLogRequestMapper {
    Log toLog(SaveLogRequestDto saveLogRequestDto);
}
