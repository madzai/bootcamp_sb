package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.repository.UserRepository;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

// stateless

@Service // ! Create Bean
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  // Call Json Place Holder Website API
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = this.restTemplate.getForObject(url, UserDTO[].class);
    return Arrays.asList(userDTOs);
  }

  @Override
  public UserEntity getById(Long id) {
    return this.userRepository.findById(id).orElse(null);
  }

  @Override
  public UserEntity create(UserEntity userEntity) {
    return this.userRepository.save(userEntity);
  }

  @Override
  public void deleteById(Long id) {
    this.userRepository.deleteById(id);
  }

  @Override
  public UserEntity updateById(Long id, UserEntity userEntity) {
    return this.userRepository.findById(id) //
        .map(entity -> {
          entity.setName(userEntity.getName());
          entity.setUsername(userEntity.getUsername());
          entity.setEmail(userEntity.getEmail());
          entity.setPhone(userEntity.getPhone());
          entity.setWebsite(userEntity.getWebsite());
          entity.setAddress_street(userEntity.getAddress_street());
          entity.setAddress_suite(userEntity.getAddress_suite());
          entity.setAddress_city(userEntity.getAddress_city());
          entity.setAddress_zipcode(userEntity.getAddress_zipcode());
          entity.setAddress_latitude(userEntity.getAddress_latitude());
          entity.setAddress_longitude(userEntity.getAddress_longitude());
          entity.setCompany_name(userEntity.getCompany_name());
          entity.setCompany_catchPhrase(userEntity.getCompany_catchPhrase());
          entity.setCompany_bs(userEntity.getCompany_bs());
          return this.userRepository.save(userEntity);
        }).orElse(null);
  }
}

