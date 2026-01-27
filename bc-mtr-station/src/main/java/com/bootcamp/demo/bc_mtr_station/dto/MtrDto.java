package com.bootcamp.demo.bc_mtr_station.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MtrDto {
  private String name;
  private String prev;
  private String next;
  private String line;
}
