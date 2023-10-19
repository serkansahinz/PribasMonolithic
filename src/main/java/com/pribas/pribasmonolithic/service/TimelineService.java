package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.exception.ErrorType;
import com.pribas.pribasmonolithic.exception.TimelineException;
import com.pribas.pribasmonolithic.mapper.ITimelineMapper;
import com.pribas.pribasmonolithic.model.Info;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.repository.ITimelineRepository;
import lombok.RequiredArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimelineService {

    public final ITimelineRepository timelineRepository;


    public List<Timeline> findAllTimelines() {
       return timelineRepository.findAll();
    }

    public Timeline findTimelineById(ObjectId id) {

        return timelineRepository.findById(id.toString()).
                orElseThrow(() -> new TimelineException(ErrorType.TIMELINE_NOT_FOUND));
    }

    public TimeLineResponseDto createTimeline(TimelineRequestDto timelineRequestDto) {

        Timeline timeline= ITimelineMapper.INSTANCE.toTimeline(timelineRequestDto);
        timelineRepository.save(timeline);
        return ITimelineMapper.INSTANCE.toTimeLineResponseDto(timeline);
    }

    public TimeLineResponseDto updateTimelineByName(TimelineRequestDto timelineRequestDto) {

        Optional<Timeline> timeline=timelineRepository.findById(timelineRequestDto.getTimelineId().toString());

        Info info = null;
        info.setTitle(timelineRequestDto.getTitle());
        info.setDescription(timelineRequestDto.getDescription());

        timeline.get().setInfo(info);
        timeline.get().setMoments(timelineRequestDto.getMoments());
        timeline.get().setTags(timelineRequestDto.getTags());
        timeline.get().setUserId(timelineRequestDto.getUserId());
        timelineRepository.save(timeline.get());
        return ITimelineMapper.INSTANCE.toTimeLineResponseDto(timeline.get());



    }

    public String deleteTimelineById(ObjectId id) {

        Optional<Timeline> timeline=timelineRepository.findById(id.toString());

       if (timeline.isEmpty()){
            return "No such timeline with timeline id" + id;
        }
        timelineRepository.deleteById(id.toString());
        return id + " titled timeline has been deleted";
    }

    public List<Moment> findMomentsByTimeline(ObjectId timelineId) {
        Timeline timeline = timelineRepository.findById(timelineId.toString()).get();
        return timeline.getMoments();
    }

    public List<Timeline> searchTimeline(String key) {
        return timelineRepository.findTimelinesByTitleOrDescriptionContaining(key);
    }
}
