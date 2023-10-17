package com.pribas.pribasmonolithic.mapper;

import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.model.Moment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMomentMapper {

IMomentMapper INSTANCE = Mappers.getMapper(IMomentMapper.class);

Moment toMoment (MomentResponseDto momentResponseDto);
MomentResponseDto toMomentResponseDto (Moment moment);



}
