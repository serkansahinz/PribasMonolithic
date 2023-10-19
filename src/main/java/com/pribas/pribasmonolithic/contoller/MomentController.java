package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.model.Moment;

import com.pribas.pribasmonolithic.service.MomentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.pribas.pribasmonolithic.constant.RestApiUrl.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(MOMENT)
public class MomentController {

    public final MomentService momentService;

    @GetMapping("/")
    public ResponseEntity<List<Moment>> findAllMoments(){
        return ResponseEntity.ok(momentService.findAllMoments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moment> findMomentById(@PathVariable String id){
        return ResponseEntity.ok(momentService.findMomentById(id));
    }

    @PostMapping("/")
    public ResponseEntity<MomentResponseDto> createMoment(@RequestBody Moment moment){
        return ResponseEntity.ok(momentService.createMoment(moment));

    }
    @PutMapping("/")
    public ResponseEntity<MomentResponseDto> updateMomentByTitle(@RequestBody Moment moment){
        return ResponseEntity.ok(momentService.updateMomentByTitle(moment));
    }

    @DeleteMapping("/delete_moment")
    public String deleteMoment(@RequestBody Moment moment){
        return momentService.deleteMoment(moment);
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<List<Moment>> searchMoment(@PathVariable String key) {
        return ResponseEntity.ok(momentService.searchMoment(key));
    }

}
