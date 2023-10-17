package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class Moment extends BaseEntity {

    @Id
    private String MomentId;
    private Info info;
    @Builder.Default
    private LocalDateTime momentTime=LocalDateTime.now();
    private List<String> attachments; // attachments: [ File ],
//    private BaseEntity creationDate; // sor


//    moment:{
//        title: String,
//                description: String,
//                moment_date: datetime,
//                attachments: [ File ],
//        creation_date: datetime
//    }


}
