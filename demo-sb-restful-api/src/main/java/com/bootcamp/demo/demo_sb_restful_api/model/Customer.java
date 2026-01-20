package com.bootcamp.demo.demo_sb_restful_api.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class Customer {
  @Setter
  private Long id;
  private String name;
  @Setter
  private LocalDate dob;
  @Setter
  private String email;
}
