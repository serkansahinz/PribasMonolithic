package com.pribas.pribasmonolithic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Moment extends BaseEntity {

//    private Long id;
    private Info info;
    @Builder.Default
    private LocalDateTime momentTime = LocalDateTime.now();
    private List<String> attachments; // attachments: [ File ],
    private BaseEntity creationDate; // sor


//    moment:{
//        title: String,
//                description: String,
//                moment_date: datetime,
//                attachments: [ File ],
//        creation_date: datetime
//    }


}
