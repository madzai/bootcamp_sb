package com.bootcamp.demo.demo_sb_restful_api.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Customer {
  private String name;
  private LocalDate dob;
  private String email;
}
