package com.bootcamp.demo.demo_external_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "jph_users")
@Getter
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  // ! By default, String -> varchar(255)
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String latitude;
  private String longitude;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "company_catchPhrase")
  private String companyCatchPhrase;
  @Column(name = "company_bs")
  private String companyBs;

}
