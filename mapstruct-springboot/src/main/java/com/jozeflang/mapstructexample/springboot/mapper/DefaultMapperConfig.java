package com.jozeflang.mapstructexample.springboot.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {DateMapper.class})
public interface DefaultMapperConfig {

}
