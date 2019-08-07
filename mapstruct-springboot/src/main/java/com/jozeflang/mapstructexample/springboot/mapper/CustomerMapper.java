package com.jozeflang.mapstructexample.springboot.mapper;

import com.jozeflang.mapstructexample.springboot.dto.*;
import com.jozeflang.mapstructexample.springboot.entity.AddressEntity;
import com.jozeflang.mapstructexample.springboot.entity.CustomerEntity;
import com.jozeflang.mapstructexample.springboot.entity.NameEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.TimeZone;

@Mapper(config = DefaultMapperConfig.class)
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = CustomerEntity.Fields.name + "." + NameEntity.Fields.title, target = CustomerDto.Fields.title),
            @Mapping(source = CustomerEntity.Fields.name + "." + NameEntity.Fields.firstName, target = CustomerDto.Fields.firstName),
            @Mapping(source = CustomerEntity.Fields.name + "." + NameEntity.Fields.surname, target = CustomerDto.Fields.lastName),
            @Mapping(source = CustomerEntity.Fields.lastUpdate, target = CustomerDto.Fields.lastUpdateStringInJapanTimeZone)
    })
    CustomerDto customerEntityToCustomerDto(CustomerEntity customerEntity, @Context TimeZone timeZone);

    CustomerWithPrimaryAddressOnlyDto customerEntityToCustomerWithPrimaryAddressOnlyDto(CustomerEntity customerEntity);

    @Mappings({
            @Mapping(source = "primaryAddress." + AddressEntity.Fields.street, target = CustomerWithPrimaryAddressOnlyFlattenDto.Fields.street),
            @Mapping(source = "primaryAddress." + AddressEntity.Fields.city, target = CustomerWithPrimaryAddressOnlyFlattenDto.Fields.city)
    })
    CustomerWithPrimaryAddressOnlyFlattenDto customerEntityToCustomerWithPrimaryAddressOnlyFlattenDto(CustomerEntity customerEntity);


    AddressDto addressEntityToAddressDto(AddressEntity addressEntity);
    AddressEntity addressDtoToAddressEntity(AddressDto addressDto);

    NameDto nameEntityToNameDto(NameEntity nameEntity);
}
