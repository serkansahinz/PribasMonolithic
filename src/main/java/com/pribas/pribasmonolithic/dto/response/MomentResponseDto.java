package com.pribas.pribasmonolithic.dto.response;

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
public class MomentResponseDto extends Info {


    private LocalDateTime momentTime; // todo oluşan zamanlar karışır mı neye göre zamanları oluşturdu
    private List<String> attachments;

}
