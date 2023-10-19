package com.pribas.pribasmonolithic.dto.response;

import com.pribas.pribasmonolithic.model.BaseEntity;
import com.pribas.pribasmonolithic.model.Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MomentResponseDto extends BaseEntity {

    private Info info;
    private LocalDateTime momentDate;
    private List<String> attachments;

}
