package com.pribas.pribasmonolithic.exception;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;


}
