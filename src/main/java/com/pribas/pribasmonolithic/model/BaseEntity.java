package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder

public class BaseEntity {

    private String title;
    private String description;
    private LocalDateTime creationDate;

}
