package com.bootcamp.demo.demo_external_api.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_external_api.entity.CommentEntity;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

// Something -> Entity
@Component
public class EntityMapper {
  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder() //
        .name(userDTO.getName()) //
        .username(userDTO.getUsername()) //
        .email(userDTO.getEmail()) //
        .phone(userDTO.getPhone()) //
        .website(userDTO.getWebsite()) //
        .street(userDTO.getAddress().getStreet()) //
        .suite(userDTO.getAddress().getSuite()) //
        .city(userDTO.getAddress().getCity()) //
        .zipcode(userDTO.getAddress().getZipcode()) //
        .latitude(userDTO.getAddress().getGeo().getLatitude()) //
        .longitude(userDTO.getAddress().getGeo().getLongitude()) //
        .companyName(userDTO.getCompany().getName()) //
        .companyCatchPhrase(userDTO.getCompany().getCatchPhrase()) //
        .companyBs(userDTO.getCompany().getBs()) //
        .build();
  }

  public PostEntity map(PostDTO postDTO) {
    return PostEntity.builder() //
        .body(postDTO.getBody()) //
        .title(postDTO.getTitle()) //
        .build();
  }

  public CommentEntity map(CommentDTO commentDTO) {
    return CommentEntity.builder() //
        .name(commentDTO.getName()) //
        .email(commentDTO.getEmail()) //
        .body(commentDTO.getBody()) //
        .build();
  }
}
