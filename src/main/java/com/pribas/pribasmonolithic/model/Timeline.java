package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public class Timeline extends BaseEntity{

    @Id
    private ObjectId timelineId;
    private Info info;
    private List<Moment> moments;
    private ObjectId userId;
    private List<String> tags;

}
