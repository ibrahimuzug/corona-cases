package com.corona.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaseEntity {
    private Integer id;
    private String country;
    private Integer caseAmount;

    @Override
    public String toString() {
        return "Case [id=" + id + ", country=" + country + ", caseAmount=" + caseAmount + "]";
    }
}
