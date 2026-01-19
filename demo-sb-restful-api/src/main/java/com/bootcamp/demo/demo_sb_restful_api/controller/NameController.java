package com.bootcamp.demo.demo_sb_restful_api.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_restful_api.model.Database;
import com.bootcamp.demo.demo_sb_restful_api.model.NameBox;

// ! RESTful API
// 1. POST - PostMapping (add resource)
// 2. DELETE - DeleteMapping
// 3. GET - GetMapping
// 4. PUT - Refersh/Replace the whole resource by ID
// 5. PATCH - Update some field(s) inside the resource by ID

@Controller
@ResponseBody
public class NameController {
  // 1. Given a name, add into the list
  @PostMapping(value = "/name")
  public void addName(@RequestBody NameBox nameBox) {
    Database.names.add(nameBox.getName());
  }

  @GetMapping(value = "/name")
  public String getNameByIndex(@RequestParam Integer index) {
    return Database.names.get(index);
  }

  // 2. get all names
  @GetMapping(value = "/names")
  public List<String> getNames() {
    return Database.names;
  }

}
