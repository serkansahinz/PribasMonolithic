package com.pribas.pribasmonolithic.dto.request;

import com.pribas.pribasmonolithic.model.BaseEntity;
import com.pribas.pribasmonolithic.model.Info;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MomentRequestDto extends BaseEntity {


    private Info info;
    private LocalDateTime momentDate;
    private List<String> attachments;
}
