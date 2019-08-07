package com.jozeflang.mapstructexample.springboot.entity;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.RandomStringUtils;

@Value
@Builder
@FieldNameConstants
public class AddressEntity {

    private String street;
    private String city;
    private String zipCode;
    private CountryEnum countryEnum;
    private boolean primary;

    public static AddressEntity getRandom(boolean primary) {
        return AddressEntity.builder()
                .street(RandomStringUtils.randomAlphanumeric(20))
                .city(RandomStringUtils.randomAlphanumeric(10))
                .zipCode(RandomStringUtils.randomNumeric(5))
                .countryEnum(CountryEnum.GERMANY)
                .primary(primary)
                .build();
    }
}
