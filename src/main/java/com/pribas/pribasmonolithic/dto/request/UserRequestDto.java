package com.pribas.pribasmonolithic.dto.request;

import com.pribas.pribasmonolithic.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRequestDto extends BaseEntity {


    private String username;
    private String email;
    private String password;

}
