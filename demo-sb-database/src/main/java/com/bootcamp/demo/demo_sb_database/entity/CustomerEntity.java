package com.bootcamp.demo.demo_sb_database.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // Create table
@Table(name = "customers") // Exact table name in MySQL
@Getter
public class CustomerEntity {
  // ! Entity: Use Java Code to write a Create Table statement
  @Id // ! Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ! auto_increment
  private Long id;
  @Setter
  @Column(name = "c_name", length = 50) // default 255
  private String name;
  @Setter
  @Column(name = "c_dob")
  private LocalDate dob;
  @Setter
  @Column(name = "c_email", length = 50) // default 255
  private String email;

}
