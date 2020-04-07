package com.corona.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@Table("survive")
@AllArgsConstructor
public class SurviveEntity {
    @Id
    private Integer id;

    @Column
    private String country;

    @Column
    private Integer survivors;

}
