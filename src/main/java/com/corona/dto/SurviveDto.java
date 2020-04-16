package com.corona.dto;

public class SurviveDto {
    private Integer id;
    private String country;
    private Integer survivors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSurvivors() {
        return survivors;
    }

    public void setSurvivors(Integer survivors) {
        this.survivors = survivors;
    }

    @Override
    public String toString() {
        return String.format(
                "Survivors[id=%d, country='%s', survivors='%d']",
                id, country, survivors);
    }

}
