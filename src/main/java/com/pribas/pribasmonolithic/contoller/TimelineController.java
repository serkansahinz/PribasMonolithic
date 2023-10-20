package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.service.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.pribas.pribasmonolithic.constant.RestApiUrl.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(TIMELINE)
public class TimelineController {
    
    public final TimelineService timelineService;

    @GetMapping("/")
    public ResponseEntity<List<Timeline>> findAllTimelines(){
        return ResponseEntity.ok(timelineService.findAllTimelines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timeline> findTimelineById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(timelineService.findTimelineById(id));
    }

    @PostMapping("/")
    public ResponseEntity<TimeLineResponseDto> createTimeline(@RequestBody TimelineRequestDto timelineRequestDto){
        return ResponseEntity.ok(timelineService.createTimeline(timelineRequestDto));

    }
    @PutMapping("/{id}")
    public ResponseEntity<TimeLineResponseDto> updateTimeline(@PathVariable String id, @RequestBody TimelineRequestDto timelineRequestDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(timelineService.updateTimelineById(id, timelineRequestDto));
    }

    @DeleteMapping("/{id}")
    public String deleteTimelineById(@PathVariable String id) throws ResourceNotFoundException {
        return timelineService.deleteTimelineById(id);
    }

    @GetMapping("/moments/{timelineId}")
    public ResponseEntity<List<Moment>> findMomentsByTimelineId(@PathVariable String timelineId) {

        return ResponseEntity.ok(timelineService.findMomentsByTimelineId(timelineId));
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<List<Timeline>> searchTimeline(@PathVariable String key) {
        return ResponseEntity.ok(timelineService.searchTimeline(key));
    }


}
