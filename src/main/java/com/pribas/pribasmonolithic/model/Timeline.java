package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class Timeline extends BaseEntity{

    @Id
    private String timelineId;
    private Info info;
    private List<Moment> moments;
    private Long user_id; // nasıl userid: ref,
//    private BaseEntity creationDate;
    private List<String> tags;

}
//timeline:{
//        title: String,
//        description: String
//        moments: [  MomentObj ],
//        userid: ref,
//        creation_date: datetime,
//        tags: [ String ]
//        }