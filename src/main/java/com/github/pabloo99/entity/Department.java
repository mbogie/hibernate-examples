package com.github.pabloo99.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Department {

    private Integer id;
    private String name;
    private Integer managerId;
    private Integer locationId;
}
