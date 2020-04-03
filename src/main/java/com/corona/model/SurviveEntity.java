package com.corona.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class SurviveEntity {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private Integer id;

    private String country;

    private Integer survivors;

    @Override
    public String toString() {
        return "Survive [id=" + id + ", country=" + country + ", survivors=" + survivors + "]";
    }
}
