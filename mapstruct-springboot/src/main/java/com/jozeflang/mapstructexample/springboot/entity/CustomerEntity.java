package com.jozeflang.mapstructexample.springboot.entity;

import com.jozeflang.mapstructexample.springboot.dto.AddressDto;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Value
@Builder
@FieldNameConstants
public class CustomerEntity {

    private NameEntity name;
    private List<AddressEntity> addresses;
    private Instant lastUpdate;

    public AddressEntity getPrimaryAddress() {
        return addresses.stream()
                .filter(AddressEntity::isPrimary)
                .findAny()
                .orElse(null);
    }

    public CustomerEntity addAddress(AddressEntity addressEntity) {
        addresses.add(addressEntity);
        return this;
    }

    public static CustomerEntity getRandom(PersonTitleEnum title, int numberOfAddresses) {
        List<AddressEntity> addressEntities = new ArrayList<>(numberOfAddresses);
        for (int i = 0; i < numberOfAddresses; i++) {
            addressEntities.add(AddressEntity.getRandom(i == 0));
        }
        return CustomerEntity.builder()
                .name(NameEntity.getRandom(title))
                .addresses(addressEntities)
                .lastUpdate(Instant.now())
                .build();
    }

    public static class CustomerEntityBuilder {
        List<AddressEntity> addresses = new ArrayList<>();
        Instant lastUpdate = Instant.now();
    }

}
