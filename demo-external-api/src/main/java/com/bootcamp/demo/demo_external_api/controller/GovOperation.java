package com.bootcamp.demo.demo_external_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_external_api.dto.CommentDto;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;

// ! https://jsonplaceholder.typicode.com/users

public interface GovOperation {
  @GetMapping(value = "/gov/jph/users")
  List<UserDto> getJPHUsers();

  @GetMapping(value = "/gov/jph/posts")
  List<PostDto> getJPHPosts();

  @GetMapping(value = "/gov/jph/comments")
  List<CommentDto> getJPHComments();
}
