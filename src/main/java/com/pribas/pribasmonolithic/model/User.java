package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document

public class User {
    @Id
    private String userId;
    @NotBlank(message = "please enter your user name")
    private String username;
    private String email;
    private String password;

}
