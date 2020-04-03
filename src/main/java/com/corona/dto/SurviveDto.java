package com.corona.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
@Setter
public class SurviveDto {
    @NonNull
    private final String country;
    @NonNull
    private final String survivors;

}
