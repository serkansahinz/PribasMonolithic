package com.pribas.pribasmonolithic.dto.request;

import com.pribas.pribasmonolithic.model.BaseEntity;
import com.pribas.pribasmonolithic.model.Info;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MomentRequestDto extends BaseEntity {


    private Info info;
    private LocalDateTime momentDate;
    private List<String> attachments;
}
