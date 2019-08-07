package com.jozeflang.mapstructexample.springboot.dto;

import com.jozeflang.mapstructexample.springboot.entity.AddressEntity;
import com.jozeflang.mapstructexample.springboot.entity.NameEntity;
import com.jozeflang.mapstructexample.springboot.entity.PersonTitleEnum;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.Instant;
import java.util.List;

@Value
@Builder
@FieldNameConstants
public class CustomerDto {
    private PersonTitleEnum title;
    private String firstName;
    private String lastName;
    private List<AddressEntity> addresses;
    private Instant lastUpdate;
    private String lastUpdateStringInJapanTimeZone;
}
