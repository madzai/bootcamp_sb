package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

// stateless

@Service // ! Create Bean
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  // Call Json Place Holder Website API
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "supercat") // ! Bean Name
  private Cat abc;

  public Cat getCat() {
    return this.abc;
  }

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = this.restTemplate.getForObject(url, UserDTO[].class);
    return Arrays.asList(userDTOs);
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] postDTOs = this.restTemplate.getForObject(url, PostDTO[].class);
    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] commentDTOs =
        this.restTemplate.getForObject(url, CommentDTO[].class);
    return Arrays.asList(commentDTOs);
  }
}
