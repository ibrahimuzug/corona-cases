package com.corona.model;

import javax.persistence.*;

@Entity
public class Death {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String country;

    @Column
    private Integer deaths;

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "Deaths [id=" + id + ", country=" + country + ", deaths=" + deaths + "]";
    }
}
