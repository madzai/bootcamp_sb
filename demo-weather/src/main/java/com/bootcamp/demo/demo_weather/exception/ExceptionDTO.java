package com.bootcamp.demo.demo_weather.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionDTO {
  private int code;
  private String message;
}
