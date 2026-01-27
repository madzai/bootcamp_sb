package com.bootcamp.demo.bc_mtr_station.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_mtr_station.dto.MtrDto;

public interface MtrOperation {
  @GetMapping(value = "/mtr/station")
  List<MtrDto> getStation(@RequestParam String name);

}
