package com.pribas.pribasmonolithic.dto.response;

import com.pribas.pribasmonolithic.model.Info;
import com.pribas.pribasmonolithic.model.Moment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TimeLineResponseDto extends Info {


    private List<Moment> moments;
    private ObjectId userId;
    private List<String> tags;
}
