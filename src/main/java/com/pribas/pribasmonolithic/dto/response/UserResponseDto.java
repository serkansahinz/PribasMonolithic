package com.pribas.pribasmonolithic.dto.response;

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
public class UserResponseDto extends BaseEntity {


    private String username;
    private String email;

}
