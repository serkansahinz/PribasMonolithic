package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.service.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timeline")
public class TimelineController {
    
    public final TimelineService timelineService;


    @GetMapping("/find_all")
    public ResponseEntity<List<Timeline>> findAllTimelines(){
        return ResponseEntity.ok(timelineService.findAllTimelines());
    }

    @GetMapping("/find_timeline_by_id/{id}")
    public ResponseEntity<Timeline> findTimelineById(@PathVariable String id){
        return ResponseEntity.ok(timelineService.findTimelineById(id).get());
    }

    @PostMapping("/create_timeline")
    public ResponseEntity<TimeLineResponseDto> createTimeline(@RequestBody TimelineRequestDto timelineRequestDto){
        return ResponseEntity.ok(timelineService.createTimeline(timelineRequestDto));

    }
    @PutMapping("/update_timeline")
    public ResponseEntity<TimeLineResponseDto> updateTimeline(@RequestBody TimelineRequestDto timelineRequestDto){
        return ResponseEntity.ok(timelineService.updateTimelineByName(timelineRequestDto));
    }

    @DeleteMapping("/delete_timeline")
    public String deleteTimeline(@RequestBody TimelineRequestDto timelineRequestDto){
        return timelineService.deleteTimeline(timelineRequestDto);
    }
}
