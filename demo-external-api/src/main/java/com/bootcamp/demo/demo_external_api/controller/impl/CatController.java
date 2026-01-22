package com.bootcamp.demo.demo_external_api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController
public class CatController {
  @Autowired
  private JsonPlaceHolderService jsonPlaceHolderService;

  @GetMapping(value = "/cat")
  public Cat getCat() {
    return this.jsonPlaceHolderService.getCat();
  }
}
