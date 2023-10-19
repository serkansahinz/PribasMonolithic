package com.pribas.pribasmonolithic.dto.request;

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
public class TimelineRequestDto extends Info {

    private ObjectId timelineId;
    private List<Moment> moments;
    private ObjectId userId;
    private List<String> tags;
}
