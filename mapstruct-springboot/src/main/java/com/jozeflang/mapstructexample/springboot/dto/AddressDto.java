package com.jozeflang.mapstructexample.springboot.dto;

import com.jozeflang.mapstructexample.springboot.entity.CountryEnum;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@Builder
@FieldNameConstants
public class AddressDto {

    private String street;
    private String city;
    private String zipCode;
    private CountryEnum countryEnum;
    private boolean primary;

    public static class AddressDtoBuilder {
        private boolean primary = false;
    }

}
