package com.pribas.pribasmonolithic.mapper;

import com.pribas.pribasmonolithic.dto.request.MomentRequestDto;
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
Moment toMoment(MomentRequestDto momentRequestDto);
MomentResponseDto toMomentResponseDto (Moment moment);



}
