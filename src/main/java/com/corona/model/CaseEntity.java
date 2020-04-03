package com.corona.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class CaseEntity {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private Integer id;

    private String country;

    private Integer caseAmount;

    @Override
    public String toString() {
        return "Case [id=" + id + ", country=" + country + ", caseAmount=" + caseAmount + "]";
    }
}
