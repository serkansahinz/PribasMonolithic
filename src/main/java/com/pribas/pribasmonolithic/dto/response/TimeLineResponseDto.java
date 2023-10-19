package com.pribas.pribasmonolithic.dto.response;

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
public class TimeLineResponseDto extends BaseEntity {

    private Info info;
    private List<Moment> moments;
    private String userId;
    private List<String> tags;
}
