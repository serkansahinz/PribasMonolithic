package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.mapper.ITimelineMapper;
import com.pribas.pribasmonolithic.model.Info;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.repository.ITimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TimelineService {

    public final ITimelineRepository timelineRepository;


    public List<Timeline> findAllTimelines() {
       return timelineRepository.findAll();
    }

    public Timeline findTimelineById(String id) throws ResourceNotFoundException {

        return timelineRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Timeline not found, ID : " + id));
    }

    public TimeLineResponseDto createTimeline(TimelineRequestDto timelineRequestDto) {

        Timeline timeline= ITimelineMapper.INSTANCE.toTimeline(timelineRequestDto);
        timelineRepository.save(timeline);
        return ITimelineMapper.INSTANCE.toTimeLineResponseDto(timeline);
    }

    public TimeLineResponseDto updateTimelineById(String id, TimelineRequestDto timelineRequestDto) throws ResourceNotFoundException {

        Timeline timeline=timelineRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Timeline not found, ID : " + id));




        timeline.setInfo(timelineRequestDto.getInfo());
        timeline.setMoments(timelineRequestDto.getMoments());
        timeline.setTags(timelineRequestDto.getTags());
        timeline.setUserId(timelineRequestDto.getUserId());
        timelineRepository.save(timeline);
        return ITimelineMapper.INSTANCE.toTimeLineResponseDto(timeline);



    }

    public String deleteTimelineById(String id) throws ResourceNotFoundException {
        Timeline timeline = timelineRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Timeline not found, ID : " + id));

        timelineRepository.deleteById(id);
        return id + " id numbered timeline has been deleted";
    }

    public List<Moment> findMomentsByTimelineId(String timelineId) {
        Timeline timeline = timelineRepository.findById(timelineId).get();
        return timeline.getMoments();
    }

    public List<Timeline> searchTimeline(String key) {
        return timelineRepository.findTimelinesByTitleOrDescriptionContaining(key);
    }
}
