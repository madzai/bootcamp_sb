package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
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

  // ! Check dependency - application.yml
  @Value("${external-api.jsonplaceholder.domain}")
  private String domain;
  // ! Check dependency - application.yml
  @Value("${external-api.jsonplaceholder.uri.users}")
  private String userPath;
  // ! Check dependency - application.yml
  @Value("${external-api.jsonplaceholder.uri.posts}")
  private String postPath;
  // ! Check dependency - application.yml
  @Value("${external-api.jsonplaceholder.uri.comments}")
  private String commentPath;


  // ! Call Json Place Holder Website External API
  @Autowired
  private RestTemplate restTemplate; // ! stateful

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  @Qualifier(value = "supercat") // ! Bean Name
  private Cat abc;

  public Cat getCat() {
    return this.abc;
  }

  @Override
  public List<UserDTO> getUsers() {
    // String url = "https://jsonplaceholder.typicode.com/users";
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https").host(this.domain) //
        .path(userPath) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);

    UserDTO[] userDTOs = this.restTemplate.getForObject(url, UserDTO[].class);

    this.userRepository.deleteAll();

    // ! Convert UserDTO[] to List<UserEntity>
    List<UserEntity> userEntities = Arrays.asList(userDTOs).stream() //
        .map(e -> this.entityMapper.map(e)) //
        .collect(Collectors.toList());
    // ! Store all user entities into Database
    this.userRepository.saveAll(userEntities);

    return Arrays.asList(userDTOs);
  }

  // ! Many to One
  @Override
  public List<PostDTO> getPosts() {
    // String url = "https://jsonplaceholder.typicode.com/posts";
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https").host(this.domain) //
        .path(postPath) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);

    PostDTO[] postDTOs = this.restTemplate.getForObject(url, PostDTO[].class);

    this.postRepository.deleteAll();

    List<PostEntity> postEntities = Arrays.asList(postDTOs).stream() //
        .map(e -> {
          UserEntity userEntity = this.userRepository.findById(e.getUserId()) //
              .orElseThrow(() -> new IllegalArgumentException());
          PostEntity postEntity = this.entityMapper.map(e);
          postEntity.setUserEntity(userEntity); // ! Parent Object
          return postEntity;
        }).collect(Collectors.toList());

    this.postRepository.saveAll(postEntities);

    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getComments() {
    // String url = "https://jsonplaceholder.typicode.com/comments";
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https").host(this.domain) //
        .path(commentPath) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);

    CommentDTO[] commentDTOs =
        this.restTemplate.getForObject(url, CommentDTO[].class);

    this.commentRepository.deleteAll();

    List<CommentEntity> commentEntities = Arrays.asList(commentDTOs).stream()//
        .map(e -> {
          // Find PostEntity based on CommentDTO's postId
          PostEntity postEntity = this.postRepository.findById(e.getPostId()) //
              .orElseThrow(() -> new IllegalArgumentException());
          // Get CommentEntity from CommentDTO
          CommentEntity commentEntity = this.entityMapper.map(e);
          // Set parent object for CommentEntity, i.e. the PostEntity (with id matches with CommentDTO's postId)
          commentEntity.setPostEntity(postEntity); // ! Parent Object
          return commentEntity;
        }).collect(Collectors.toList());

    this.commentRepository.saveAll(commentEntities);

    return Arrays.asList(commentDTOs);
  }
}


