package com.bootcamp.demo.demo_external_api.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_external_api.controller.GovOperation;
import com.bootcamp.demo.demo_external_api.dto.CommentDto;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.mapper.DtoMapper;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController
public class GovController implements GovOperation {
  // ! Dependency Injection (Controller生死 depends on Service)
  @Autowired
  private JsonPlaceHolderService jsonPlaceHolderService;
  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public List<UserDto> getJPHUsers() {
    // List<A> to List<B>
    return this.jsonPlaceHolderService.getUsers().stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public List<PostDto> getJPHPosts() {
    return this.jsonPlaceHolderService.getPosts().stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public List<CommentDto> getJPHComments() {
    return this.jsonPlaceHolderService.getComments().stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }
}
