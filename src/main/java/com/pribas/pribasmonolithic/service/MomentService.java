package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.request.MomentRequestDto;
import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.mapper.IMomentMapper;
import com.pribas.pribasmonolithic.model.Info;
import com.pribas.pribasmonolithic.model.Moment;
import com.pribas.pribasmonolithic.repository.IMomentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MomentService {

    public final IMomentRepository momentRepository;


    public List<Moment> findAllMoments() {
       return momentRepository.findAll();
    }

    public Moment findMomentById(String id) throws ResourceNotFoundException{
        return momentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MOMENT NOT FOUND"));
    }

    public MomentResponseDto createMoment(MomentRequestDto momentRequestDto) {
        Moment moment = IMomentMapper.INSTANCE.toMoment(momentRequestDto);

         momentRepository.save(moment);
        return IMomentMapper.INSTANCE.toMomentResponseDto(moment);
    }

    public MomentResponseDto updateMomentById(String id, MomentRequestDto momentRequestDto) throws ResourceNotFoundException {
        Moment moment = momentRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Moment not found ID : " + id));


        moment.setInfo(momentRequestDto.getInfo());
        moment.setCreationDate(momentRequestDto.getCreationDate());
        moment.setAttachments(momentRequestDto.getAttachments());

        momentRepository.save(moment);
        return IMomentMapper.INSTANCE.toMomentResponseDto(moment);


    }

    public String deleteMomentById(String id) throws ResourceNotFoundException{
        Moment moment = momentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Moment not found ID : " + id));

            momentRepository.deleteById(moment.getMomentId());
            return moment.getMomentId() + " ID moment has been deleted";
            }

    public List<Moment> searchMoment(String key) {
        return momentRepository.findMomentsByTitleOrDescriptionContaining(key);
    }
}
