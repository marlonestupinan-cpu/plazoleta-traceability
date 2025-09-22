package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.response.LogResponseDto;
import com.pragma.traceability.domain.model.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ILogResponseMapper {
    LogResponseDto toResponse(Log log);
    List<LogResponseDto> toResponseList(List<Log> logs);
}
