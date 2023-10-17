package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.service.MomentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Moment")
public class MomentController {

    public final MomentService momentService;

    @GetMapping("/find_all")
    public ResponseEntity<List<Moment>> findAllMoments(){
        return ResponseEntity.ok(momentService.findAllMoments());
    }

    @GetMapping("/find_moment_by_id/{id}")
    public ResponseEntity<Optional<Moment>> findMomentById(@PathVariable String id){
        return ResponseEntity.ok(momentService.findMomentById(id));
    }
//    @GetMapping("/find_by_timeline")
//    public ResponseEntity<List<Moment>> findMomentsByTimeline(@RequestBody Timeline timeline){
//        return  ResponseEntity.ok(momentService.findMomentsByTimeline(timeline));
//    }

    @PostMapping("/create_moment")
    public ResponseEntity<MomentResponseDto> createMoment(@RequestBody Moment moment){
        return ResponseEntity.ok(momentService.createMoment(moment));

    }
    @PutMapping("/update_moment")
    public ResponseEntity<MomentResponseDto> updateMomentByTitle(@RequestBody Moment moment){
        return ResponseEntity.ok(momentService.updateMomentByTitle(moment));
    }

//    @DeleteMapping("/delete_moment_by_title")
//    public String deleteMoment(@RequestParam String title){
//        return momentService.deleteMomentByTitle(title);
//    }
    @DeleteMapping("/delete_moment")
    public String deleteMoment(@RequestBody Moment moment){
        return momentService.deleteMoment(moment);
    }
}
