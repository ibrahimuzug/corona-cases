package com.corona.model;

import javax.persistence.*;

@Entity
public class Case {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String country;

    @Column
    private Integer caseAmount;


    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCaseAmount() {
        return caseAmount;
    }

    public void setCaseAmount(Integer caseAmount) {
        this.caseAmount = caseAmount;
    }

    @Override
    public String toString() {
        return "Case [id=" + id + ", country=" + country + ", caseAmount=" + caseAmount + "]";
    }
}
