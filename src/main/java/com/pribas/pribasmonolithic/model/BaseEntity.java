package com.pribas.pribasmonolithic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
//@MappedSuperclass biz bu base entity neden yaptık?
public class BaseEntity {

    @Builder.Default
    private LocalDateTime creation_date=LocalDateTime.now();

}
