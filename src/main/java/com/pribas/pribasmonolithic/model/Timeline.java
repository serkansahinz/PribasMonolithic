package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class Timeline extends Info{

    @Id
    private String timelineId;
    private List<Moment> moments;
    private Long user_id; // nasıl userid: ref,
    private List<String> tags;

}
