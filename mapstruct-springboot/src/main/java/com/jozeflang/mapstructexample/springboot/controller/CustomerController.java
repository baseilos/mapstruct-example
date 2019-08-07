package com.jozeflang.mapstructexample.springboot.controller;

import com.jozeflang.mapstructexample.springboot.dto.AddressDto;
import com.jozeflang.mapstructexample.springboot.dto.CustomerDto;
import com.jozeflang.mapstructexample.springboot.dto.CustomerWithPrimaryAddressOnlyDto;
import com.jozeflang.mapstructexample.springboot.dto.CustomerWithPrimaryAddressOnlyFlattenDto;
import com.jozeflang.mapstructexample.springboot.entity.AddressEntity;
import com.jozeflang.mapstructexample.springboot.entity.CustomerEntity;
import com.jozeflang.mapstructexample.springboot.entity.PersonTitleEnum;
import com.jozeflang.mapstructexample.springboot.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;

@RestController
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public CustomerDto getRandomCustomer() {
        CustomerEntity customerEntity = CustomerEntity.getRandom(PersonTitleEnum.DR, 5);
        return customerMapper.customerEntityToCustomerDto(customerEntity, TimeZone.getTimeZone("Japan"));
    }

    @RequestMapping(value = "/randomPrimaryOnly", method = RequestMethod.GET)
    public CustomerWithPrimaryAddressOnlyDto getRandomCustomerOnlyPrimaryAddress() {
        CustomerEntity customerEntity = CustomerEntity.getRandom(PersonTitleEnum.DR, 5);
        return customerMapper.customerEntityToCustomerWithPrimaryAddressOnlyDto(customerEntity);
    }

    @RequestMapping(value = "/randomPrimaryOnlyFlatten", method = RequestMethod.GET)
    public CustomerWithPrimaryAddressOnlyFlattenDto getRandomCustomerOnlyPrimaryAddressFlatten() {
        CustomerEntity customerEntity = CustomerEntity.getRandom(PersonTitleEnum.DR, 5);
        return customerMapper.customerEntityToCustomerWithPrimaryAddressOnlyFlattenDto(customerEntity);
    }

    @PostMapping(value = "/address", consumes = "application/json")
    CustomerDto updateAddress(@RequestBody AddressDto newAddress) {
        CustomerEntity customerEntity = CustomerEntity.getRandom(PersonTitleEnum.DR, 1);
        AddressEntity addressEntity = customerMapper.addressDtoToAddressEntity(newAddress);
        return customerMapper.customerEntityToCustomerDto(customerEntity.addAddress(addressEntity), TimeZone.getTimeZone("Japan"));
    }
}
