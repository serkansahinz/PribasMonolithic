package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.mapper.ITimelineMapper;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.repository.ITimelineRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimelineService {

    public final ITimelineRepository timelineRepository;


    public List<Timeline> findAllTimelines() {
       return timelineRepository.findAll();
    }

    public Optional<Timeline> findTimelineById(String id) {

        return timelineRepository.findById(id);
    }

    public TimeLineResponseDto createTimeline(TimelineRequestDto timelineRequestDto) {
        Timeline timeline= ITimelineMapper.INSTANCE.toTimeline(timelineRequestDto);
        timelineRepository.save(timeline);
        return ITimelineMapper.INSTANCE.toTimeLineResponseDto(timeline);
    }

    public TimeLineResponseDto updateTimelineByName(TimelineRequestDto timelineRequestDto) {

        Optional<Timeline> timeline=timelineRepository.findById(timelineRequestDto.getTimelineId());
        timeline.get().setTitle(timelineRequestDto.getTitle());
        timeline.get().setDescription(timelineRequestDto.getDescription());
        timeline.get().setUpdateDate(LocalDateTime.now());
        timeline.get().setTags(timelineRequestDto.getTags());
        timelineRepository.save(timeline.get());
        return ITimelineMapper.INSTANCE.toTimeLineResponseDto(timeline.get());



    }

    public String deleteTimeline(TimelineRequestDto timelineRequestDto) {

        Optional<Timeline> timeline=timelineRepository.findByTitle(timelineRequestDto.getTitle());

       if (timeline.isEmpty()){
            return "No such timeline with " + timelineRequestDto.getTitle()+ " title name";
        }
        timelineRepository.deleteById(timelineRequestDto.getTimelineId());
        return timelineRequestDto.getTitle() + " titled timeline has been deleted";
    }
}
