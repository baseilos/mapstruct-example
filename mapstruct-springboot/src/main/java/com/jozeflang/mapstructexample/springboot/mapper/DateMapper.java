package com.jozeflang.mapstructexample.springboot.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DateMapper {

    default String instantToISOString(Instant instant, @Context TimeZone timeZone) {
        if (instant == null) {
            return "";
        }
        return DateTimeFormatter.ISO_DATE_TIME.format(instant.atZone(timeZone.toZoneId()));
    }
}
