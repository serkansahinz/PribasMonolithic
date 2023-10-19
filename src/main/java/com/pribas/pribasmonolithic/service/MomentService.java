package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.response.MomentResponseDto;
import com.pribas.pribasmonolithic.exception.ErrorType;
import com.pribas.pribasmonolithic.exception.MomentException;
import com.pribas.pribasmonolithic.mapper.IMomentMapper;
import com.pribas.pribasmonolithic.model.Info;
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

    public Moment findMomentById(String id) {
        return momentRepository.findById(id).orElseThrow(() -> new MomentException((ErrorType.MOMENT_NOT_FOUND)));
    }

    public MomentResponseDto createMoment(Moment moment) {
        //kullanıcı var mı yok mu
         momentRepository.save(moment);
        return IMomentMapper.INSTANCE.toMomentResponseDto(moment);
    }

    public MomentResponseDto updateMomentByTitle(Moment moment) {
        Moment moment2 = momentRepository.findById(moment.getMomentId().toString()).get();

        Info info = null;
        info.setTitle(moment.getInfo().getTitle());
        info.setDescription(moment.getInfo().getDescription());
        moment2.setMomentId(moment.getMomentId());
        moment2.setInfo(info);
        moment2.setCreationDate(moment.getCreationDate());
        moment2.setAttachments(moment.getAttachments());

        momentRepository.save(moment2);
        return IMomentMapper.INSTANCE.toMomentResponseDto(moment2);


    }

    public String deleteMoment(Moment moment) {
            if (moment == null) {
                return "No such moment";
            }
            momentRepository.deleteById(moment.getMomentId().toString());
            return moment.getInfo().getTitle() + " titled moment has been deleted";
            }

    public List<Moment> searchMoment(String key) {
        return momentRepository.findMomentsByTitleOrDescriptionContaining(key);
    }
}
