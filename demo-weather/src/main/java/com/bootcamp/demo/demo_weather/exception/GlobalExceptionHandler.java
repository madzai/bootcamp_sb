package com.bootcamp.demo.demo_weather.exception;

import java.net.MalformedURLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = IllegalArgumentException.class)
  public ExceptionDTO handle(IllegalArgumentException e) {
    return ExceptionDTO.builder() //
        .code(SysEx.PARAM_NOT_MATCH.getCode()) //
        .message(SysEx.PARAM_NOT_MATCH.getMessage() + " " + e.getMessage()) //
        .build();
  }

  // RestClientException
  // hardcode wrong url
  @ExceptionHandler(value = ResourceAccessException.class)
  public ExceptionDTO handler(ResourceAccessException e) {
    return ExceptionDTO.builder() //
        .code(SysEx.URL_NOT_CORRECT.getCode()) //
        .message(SysEx.URL_NOT_CORRECT.getMessage() + " " + e.getMessage()) //
        .build();
  }
}
