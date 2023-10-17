package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.mapper.IMomentMapper;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.model.Timeline;
import com.pribas.pribasmonolithic.repository.IMomentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MomentService {

    public final IMomentRepository momentRepository;


    public List<Moment> findAllMoments() {
       return momentRepository.findAll();
    }

    public Optional<Moment> findMomentById(String id) {
        return momentRepository.findById(id);
    }
//    public List<Moment> findMomentsByTimeline(Timeline timeline) {
//        return momentRepository.findByTimelineTitle(timeline.getTitle());
//
//    }

    public MomentResponseDto createMoment(Moment moment) {
         momentRepository.save(moment);
        return IMomentMapper.INSTANCE.toMomentResponseDto(moment);
    }

    public MomentResponseDto updateMomentByTitle(Moment moment) {
        momentRepository.save(moment);
        return IMomentMapper.INSTANCE.toMomentResponseDto(moment);


    }

    public String deleteMoment(Moment moment) {
            if (moment == null) {
                return "No such moment";
            }
            momentRepository.deleteById(moment.getMomentId());
            return moment.getTitle() + " titled moment has been deleted";
            }

}
