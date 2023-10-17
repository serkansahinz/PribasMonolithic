package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder

public class BaseEntity implements Serializable { // TODO: 17.10.2023 neden gerekli

    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

}
