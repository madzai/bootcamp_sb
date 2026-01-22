package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.entity.CommentEntity;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.mapper.EntityMapper;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.repository.CommentRepository;
import com.bootcamp.demo.demo_external_api.repository.PostRepository;
import com.bootcamp.demo.demo_external_api.repository.UserRepository;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

// stateless

@Service // ! Create Bean
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {

  private final PostRepository postRepository;

  private final CommentRepository commentRepository;
  // Call Json Place Holder Website API
  @Autowired
  private RestTemplate restTemplate; // ! stateful

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  @Qualifier(value = "supercat") // ! Bean Name
  private Cat abc;

  JsonPlaceHolderServiceImpl(CommentRepository commentRepository,
      PostRepository postRepository) {
    this.commentRepository = commentRepository;
    this.postRepository = postRepository;
  }

  public Cat getCat() {
    return this.abc;
  }

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = this.restTemplate.getForObject(url, UserDTO[].class);

    // ! Convert UserDTO[] to List<UserEntity>
    List<UserEntity> userEntities = Arrays.asList(userDTOs).stream() //
        .map(e -> this.entityMapper.map(e)) //
        .collect(Collectors.toList());
    // ! Store all user entities into Database
    this.userRepository.saveAll(userEntities);

    return Arrays.asList(userDTOs);
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] postDTOs = this.restTemplate.getForObject(url, PostDTO[].class);

    List<PostEntity> postEntities = Arrays.asList(postDTOs).stream() //
        .map(e -> this.entityMapper.map(e)) //
        .collect(Collectors.toList());

    this.postRepository.saveAll(postEntities);

    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] commentDTOs =
        this.restTemplate.getForObject(url, CommentDTO[].class);

    List<CommentEntity> commentEntities = Arrays.asList(commentDTOs).stream() //
        .map(e -> this.entityMapper.map(e)) //
        .collect(Collectors.toList());

    this.commentRepository.saveAll(commentEntities);

    return Arrays.asList(commentDTOs);
  }
}
