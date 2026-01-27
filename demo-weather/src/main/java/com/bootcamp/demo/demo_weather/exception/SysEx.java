package com.bootcamp.demo.demo_weather.exception;

import lombok.Getter;

@Getter
public enum SysEx {
  PARAM_NOT_MATCH(90000, "Parameters Not Match."), //
  REST_CLIENT_EX(90001, "Rest Client API Call Fail."), //
  ;

  private int code;
  private String message;

  private SysEx(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
