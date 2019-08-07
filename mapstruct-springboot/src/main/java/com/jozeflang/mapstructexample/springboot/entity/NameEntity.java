package com.jozeflang.mapstructexample.springboot.entity;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.RandomStringUtils;

@Value
@Builder
@FieldNameConstants
public class NameEntity {

    private PersonTitleEnum title;
    private String firstName;
    private String surname;

    public static NameEntity getRandom(PersonTitleEnum title) {
        return NameEntity.builder()
                .title(title)
                .firstName(RandomStringUtils.randomAlphanumeric(10))
                .surname(RandomStringUtils.randomAlphanumeric(10))
                .build();
    }

}
