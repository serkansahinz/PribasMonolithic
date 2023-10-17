package com.pribas.pribasmonolithic.mapper;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.model.Timeline;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.sql.Time;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITimelineMapper {

ITimelineMapper INSTANCE = Mappers.getMapper(ITimelineMapper.class);

Timeline toTimeline(TimelineRequestDto timelineRequestDto);
Timeline toTimeline(TimeLineResponseDto timeLineResponseDto);

TimelineRequestDto toTimelineRequestDto(Timeline timeline);

TimeLineResponseDto toTimeLineResponseDto (Timeline timeline);



}
