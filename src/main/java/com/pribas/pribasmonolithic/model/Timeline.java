package com.pribas.pribasmonolithic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Timeline extends BaseEntity{

    private Long timelineId;
    private Info info;
    private List<Moment> moments;
    private Long user_id; // nasıl userid: ref,

    private BaseEntity creationDate;
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