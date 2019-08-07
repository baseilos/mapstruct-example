package com.jozeflang.mapstructexample.springboot.dto;

import com.jozeflang.mapstructexample.springboot.entity.NameEntity;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.Instant;

@Value
@Builder
@FieldNameConstants
public class CustomerWithPrimaryAddressOnlyFlattenDto {
    private NameEntity name;
    private String street;
    private String city;
    private Instant lastUpdate;
}
