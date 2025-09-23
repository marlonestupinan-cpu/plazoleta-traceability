package com.pragma.traceability.application.mapper;

import com.pragma.traceability.application.dto.response.OrderResumeDto;
import com.pragma.traceability.domain.model.OrderResume;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderResumeMapper {
    OrderResumeDto toOrderResumeDto(OrderResume orderResume);
    List<OrderResumeDto> toListOrderResumeDto(List<OrderResume> orderResumes);
}
