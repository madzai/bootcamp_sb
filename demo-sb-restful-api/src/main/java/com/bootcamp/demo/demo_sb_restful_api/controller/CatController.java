package com.bootcamp.demo.demo_sb_restful_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class CatController {
  // name, age (PathVariable, RequestParam)
  // return a cat object

  // ! http://localhost:8080/cat/Alan/3
  @GetMapping(value = "/cat/{name}/{age}")
  public Cat create(@PathVariable String name, @PathVariable Integer age) {
    return new Cat(name, age);
  }

  // ! http://localhost:8080/cat?name=Alan&age=3
  @GetMapping(value = "/cat")
  public Cat create2(@RequestParam String name, @RequestParam Integer age) {
    return new Cat(name, age);
  }

  // Cat[]
  @GetMapping(value = "/cats/{name}/{age}")
  public Cat[] create3(@PathVariable String name, @PathVariable Integer age) {
    return new Cat[] {new Cat(name, age)};
  }

  // List<Cat>
  @GetMapping(value = "/cats")
  public List<Cat> create4(@RequestParam String name,
      @RequestParam Integer age) {
    // return new LinkedList<Cat>(List.of(new Cat(name, age)));
    return List.of(new Cat(name, age));
  }

  // Map<String, Cat>
  @GetMapping(value = "/catmap")
  public Map<String, Cat> createMap() {
    Cat c1 = new Cat("John", 1);
    Cat c2 = new Cat("Peter", 3);
    Map<String, Cat> catMap = new HashMap<>();
    catMap.put(c1.getName(), c1);
    catMap.put(c2.getName(), c2);
    return catMap;
  }

  // Set<Cat>
  @GetMapping(value = "/catset")
  public Set<Cat> create6() {
    return Set.of(new Cat("Kelly", 2));
  }


}
