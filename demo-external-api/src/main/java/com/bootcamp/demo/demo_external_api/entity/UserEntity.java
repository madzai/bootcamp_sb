package com.bootcamp.demo.demo_external_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(name = "name", length = 50)
  private String name;
  @Setter
  @Column(name = "username", length = 50)
  private String username;
  @Setter
  @Column(name = "email", length = 50)
  private String email;
  @Setter
  @Column(name = "phone", length = 50)
  private String phone;
  @Setter
  @Column(name = "website", length = 100)
  private String website;

  // Address
  @Setter
  @Column(name = "address_street", length = 50)
  private String address_street;
  @Setter
  @Column(name = "address_suite", length = 50)
  private String address_suite;
  @Setter
  @Column(name = "address_city", length = 50)
  private String address_city;
  @Setter
  @Column(name = "address_zipcode", length = 50)
  private String address_zipcode;
  @Setter
  @Column(name = "address_latitude", length = 50)
  private String address_latitude;
  @Setter
  @Column(name = "address_longitude", length = 50)
  private String address_longitude;

  // Company
  @Setter
  @Column(name = "company_name", length = 50)
  private String company_name;
  @Setter
  @Column(name = "company_catchPhrase", length = 50)
  private String company_catchPhrase;
  @Setter
  @Column(name = "company_bs", length = 50)
  private String company_bs;

}
