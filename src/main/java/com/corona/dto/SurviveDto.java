package com.corona.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
public class SurviveDto {
    @NonNull
    private final String country;
    @NonNull
    private final String survivors;

}
