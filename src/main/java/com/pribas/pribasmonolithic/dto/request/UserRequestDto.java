package com.pribas.pribasmonolithic.dto.request;

import com.pribas.pribasmonolithic.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRequestDto extends BaseEntity {


    private String username;
    private String email;
    private String password;

}
