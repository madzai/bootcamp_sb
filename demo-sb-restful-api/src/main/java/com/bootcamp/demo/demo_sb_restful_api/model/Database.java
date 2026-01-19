package com.bootcamp.demo.demo_sb_restful_api.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Database {
  public static List<String> names = new ArrayList<>();

  // List<Customer>
  public static List<Customer> customers = new ArrayList<>();

}
