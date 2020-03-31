package com.corona.model;

import javax.persistence.*;

@Entity
public class Survive {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String country;

    @Column
    private Integer survivors;

    public Integer getId() {
        return id;
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
        return "Survive [id=" + id + ", country=" + country + ", survivors=" + survivors + "]";
    }
}
