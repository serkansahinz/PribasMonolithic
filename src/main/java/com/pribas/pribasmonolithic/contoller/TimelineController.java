package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.request.TimelineRequestDto;
import com.pribas.pribasmonolithic.dto.response.TimeLineResponseDto;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.service.TimelineService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
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
    public ResponseEntity<Timeline> findTimelineById(@PathVariable ObjectId id){
        return ResponseEntity.ok(timelineService.findTimelineById(id));
    }

    @PostMapping("/")
    public ResponseEntity<TimeLineResponseDto> createTimeline(@RequestBody TimelineRequestDto timelineRequestDto){
        return ResponseEntity.ok(timelineService.createTimeline(timelineRequestDto));

    }
    @PutMapping("/")
    public ResponseEntity<TimeLineResponseDto> updateTimeline(@RequestBody TimelineRequestDto timelineRequestDto){
        return ResponseEntity.ok(timelineService.updateTimelineByName(timelineRequestDto));
    }

    @DeleteMapping("/{id}")
    public String deleteTimelineById(@PathVariable ObjectId id){
        return timelineService.deleteTimelineById(id);
    }

    @GetMapping("/moments/{timelineId}")
    public ResponseEntity<List<Moment>> findMomentsByTimeline(@PathVariable ObjectId timelineId) {

        return ResponseEntity.ok(timelineService.findMomentsByTimeline(timelineId));
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<List<Timeline>> searchTimeline(@PathVariable String key) {
        return ResponseEntity.ok(timelineService.searchTimeline(key));
    }


}
