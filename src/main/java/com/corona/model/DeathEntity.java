package com.corona.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeathEntity {
    private Integer id;
    private String country;
    private Integer deaths;

    @Override
    public String toString() {
        return "Deaths [id=" + id + ", country=" + country + ", deaths=" + deaths + "]";
    }
}
