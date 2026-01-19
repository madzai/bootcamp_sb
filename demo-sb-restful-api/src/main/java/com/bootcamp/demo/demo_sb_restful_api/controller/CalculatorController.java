package com.bootcamp.demo.demo_sb_restful_api.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// ! JDK doesn't know what you're talking about
@Controller
@ResponseBody
public class CalculatorController {
  // ! @PathVariable (accept parameters)
  @GetMapping(value = "/sum/{x}/{y}")
  public Integer sum(@PathVariable Integer x, @PathVariable Integer y) {
    // create 10000000 string objects
    // String s = "hello";
    return x + y;
  }

  @GetMapping(value = "/difference/{x}/{y}")
  public Integer minus(@PathVariable Integer x, @PathVariable Integer y) {
    return x - y;
  }

  @GetMapping(value = "/product/{x}/{y}")
  public Double multiply(@PathVariable Double x, @PathVariable Double y) {
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
  }

  // ! @RequestParam
  // ! http://localhost:8080/quotient?x=10&y=3
  @GetMapping(value = "/quotient")
  public Double divide(@RequestParam Double x, @RequestParam Double y) {
    return BigDecimal.valueOf(x) //
        .divide(BigDecimal.valueOf(y), 2, RoundingMode.HALF_UP) //
        .doubleValue();
  }

}
