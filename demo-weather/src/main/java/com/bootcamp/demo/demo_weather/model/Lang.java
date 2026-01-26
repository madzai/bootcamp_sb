package com.bootcamp.demo.demo_weather.model;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum Lang {
  EN("en"), //
  TC("tc"), //
  ;

  private String value;

  private Lang(String value) {
    this.value = value;
  }

  public static Lang of(String lang) {
    return Arrays.asList(Lang.values()).stream() //
        .filter(e -> e.getValue().equals(lang)) //
        .findAny() //
        .orElseThrow(() -> new IllegalArgumentException("ENUM not Found."));
  }

  public static void main(String[] args) {
    Lang l1 = Lang.valueOf("EN"); // built-in valueOf() -> case-sensitive

    // "en" -> Lang.EN
    Lang l2 = Lang.of("en");
    System.out.println(l2.getValue());
  }
}
