package com.corona.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class DeathEntity {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private Integer id;

    private String country;

    private Integer deaths;

}
