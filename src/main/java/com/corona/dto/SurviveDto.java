package com.corona.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder(toBuilder = true)
@Table("survive")
@AllArgsConstructor
public class SurviveDto {
    @Id
    private final Integer id;
    @Column
    private final String country;
    @Column
    private final String survivors;

}
