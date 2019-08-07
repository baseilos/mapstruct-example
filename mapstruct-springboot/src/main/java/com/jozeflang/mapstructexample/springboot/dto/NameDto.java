package com.jozeflang.mapstructexample.springboot.dto;

import com.jozeflang.mapstructexample.springboot.entity.PersonTitleEnum;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@Builder
@FieldNameConstants
public class NameDto {

    private PersonTitleEnum title;
    private String firstName;
    private String surname;

}
