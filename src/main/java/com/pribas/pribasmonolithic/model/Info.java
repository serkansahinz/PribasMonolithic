package com.pribas.pribasmonolithic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Info { // TODO: 17.10.2023 bu sınıfa gerek var mı sil herşey bitince
    private String title;
    private String description;

}
