package com.pribas.pribasmonolithic.dto.request;

import com.pribas.pribasmonolithic.model.BaseEntity;
import com.pribas.pribasmonolithic.model.Info;
import com.pribas.pribasmonolithic.model.Moment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TimelineRequestDto extends BaseEntity {


    private Info info;
    private List<Moment> moments;
    private String userId;
    private List<String> tags;
}
