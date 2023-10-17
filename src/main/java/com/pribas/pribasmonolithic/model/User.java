package com.pribas.pribasmonolithic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
// mongo eklenecek
public class User {
    @Id
    private Long userId;
    private String username;
    private String email;
    private String password;

}
