package com.bootcamp.demo.demo_external_api.service;

import java.util.List;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public interface JsonPlaceHolderService {
  List<UserDTO> getUsers();

  UserEntity getById(Long id);

  UserEntity create(UserEntity userEntity);

  void deleteById(Long id);

  UserEntity updateById(Long id, UserEntity userEntity);
}
