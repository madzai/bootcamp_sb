package com.bootcamp.demo.demo_sb_restful_api.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalculatorController {
  @GetMapping(value = "/sum/{x}/{y}")
  public Integer sum(@PathVariable Integer x, @PathVariable Integer y) {
    return x + y;
  }

  @GetMapping(value = "/difference/{x}/{y}")
  public Integer minus(@PathVariable Integer x, @PathVariable Integer y) {
    return x - y;
  }

  @GetMapping(value = "/product/{x}/{y}")
  public Integer multiply(@PathVariable Integer x, @PathVariable Integer y) {
    return x * y;
  }

  @GetMapping(value = "/quotient/{x}/{y}")
  public Double divide(@PathVariable Integer x, @PathVariable Integer y) {
    return BigDecimal.valueOf(x)
        .divide(BigDecimal.valueOf(y), 2, RoundingMode.HALF_UP).doubleValue();
  }

}
