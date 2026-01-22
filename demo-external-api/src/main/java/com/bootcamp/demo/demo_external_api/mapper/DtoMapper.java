package com.bootcamp.demo.demo_external_api.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_external_api.dto.CommentDto;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
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

  public PostDto map(PostDTO postDTO) {
    return PostDto.builder() //
        // .userId(postDTO.getUserId()) //
        // .id(postDTO.getId()) //
        .title(postDTO.getTitle()) //
        .body(postDTO.getBody()) //
        .build();
  }

  public CommentDto map(CommentDTO commentDTO) {
    return CommentDto.builder() //
        .name(commentDTO.getName()) //
        .body(commentDTO.getBody()) //
        .build();
  }

}
