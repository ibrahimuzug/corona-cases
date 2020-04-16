package com.corona.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Getter
@Setter
@Table("survivors")
public class SurviveEntity {
    private @Id
    Integer id;
    private String country;
    private Integer survivors;
}
