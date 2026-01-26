package com.bootcamp.demo.demo_weather.exception;

import java.net.MalformedURLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
  @ExceptionHandler(value = MalformedURLException.class)
  public ExceptionDTO handler(MalformedURLException e) {
    return ExceptionDTO.builder() //
        .code(SysEx.URL_NOT_CORRECT.getCode()) //
        .message(SysEx.URL_NOT_CORRECT.getMessage() + " " + e.getMessage()) //
        .build();
  }
}
