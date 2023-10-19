package com.pribas.pribasmonolithic.dto.response;

import com.pribas.pribasmonolithic.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserResponseDto extends BaseEntity {


    private String username;
    private String email;

}
