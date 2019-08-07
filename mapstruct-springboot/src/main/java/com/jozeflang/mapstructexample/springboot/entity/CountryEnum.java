package com.jozeflang.mapstructexample.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryEnum {
    GERMANY("DE"),
    UNITED_KINGDOM("UK");

    private final String countryCode;
}
