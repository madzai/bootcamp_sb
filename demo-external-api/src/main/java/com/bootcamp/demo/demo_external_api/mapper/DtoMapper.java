package com.bootcamp.demo.demo_external_api.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

@Component // !
public class DtoMapper {
  // ! from static method to instance method
  public UserDto map(UserDTO userDTO) {
    return UserDto.builder() //
        .id(userDTO.getId()) //
        .email(userDTO.getEmail()) //
        .name(userDTO.getName()) //
        .username(userDTO.getUsername()) //
        .build();
  }
}
