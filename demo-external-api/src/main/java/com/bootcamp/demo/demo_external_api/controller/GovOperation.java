package com.bootcamp.demo.demo_external_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;

// ! https://jsonplaceholder.typicode.com/users

public interface GovOperation {
  @GetMapping(value = "/gov/jph/users")
  List<UserDto> getJPHUsers();

  @PostMapping(value = "/gov/jph/user")
  UserEntity create(@RequestBody UserEntity userEntity);

  @GetMapping(value = "/gov/jph/user")
  UserEntity getById(@RequestParam Long id);

  @DeleteMapping(value = "/gov/jph/user")
  void deleteById(@RequestParam Long id);

  @PutMapping(value = "/gov/jph/user")
  UserEntity updateById(@RequestParam Long id,
      @RequestBody UserEntity userEntity);

}
