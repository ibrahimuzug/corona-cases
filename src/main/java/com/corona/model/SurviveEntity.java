package com.corona.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SurviveEntity {

    private Integer id;
    private String country;
    private Integer survivors;

    @Override
    public String toString() {
        return "Survive [id=" + id + ", country=" + country + ", survivors=" + survivors + "]";
    }
}
