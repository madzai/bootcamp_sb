package com.bootcamp.demo.demo_weather.exception;

import lombok.Getter;

@Getter
public enum SysEx {
  PARAM_NOT_MATCH(90000, "Parameters Not Match."), //
  URL_NOT_CORRECT(90001, "URL is incorrect."), //
  ;

  private int code;
  private String message;

  private SysEx(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
