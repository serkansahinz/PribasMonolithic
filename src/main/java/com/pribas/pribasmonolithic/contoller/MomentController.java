package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.request.MomentRequestDto;
import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.model.Moment;

import com.pribas.pribasmonolithic.service.MomentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.pribas.pribasmonolithic.constant.RestApiUrl.*;

import java.util.List;

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
    public ResponseEntity<Moment> findMomentById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(momentService.findMomentById(id));
    }

    @PostMapping("/")
    public ResponseEntity<MomentResponseDto> createMoment(@RequestBody MomentRequestDto momentRequestDto){
        return ResponseEntity.ok(momentService.createMoment(momentRequestDto));

    }
    @PutMapping("/{id}")
    public ResponseEntity<MomentResponseDto> updateMomentById(@PathVariable String id, @RequestBody MomentRequestDto momentRequestDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(momentService.updateMomentById(id, momentRequestDto));
    }

    @DeleteMapping("/{id}")
    public String deleteMomentById(@PathVariable String id) throws ResourceNotFoundException {
        return momentService.deleteMomentById(id);
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<List<Moment>> searchMoment(@PathVariable String key) {
        return ResponseEntity.ok(momentService.searchMoment(key));
    }

}
