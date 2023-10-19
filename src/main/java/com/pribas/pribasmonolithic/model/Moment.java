package com.pribas.pribasmonolithic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class Moment extends BaseEntity {

    @Id
    private ObjectId momentId;
    private Info info;
    @Builder.Default
    private LocalDateTime momentDate=LocalDateTime.now();
    private List<String> attachments; // attachments: [ File ],



}
