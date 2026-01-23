package com.bootcamp.demo.demo_external_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jph_comments")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String name;
  @Column(length = 1000)
  private String body;

  @ManyToOne
  @JoinColumn(name = "post_id")
  @Setter
  private PostEntity postEntity;
}
