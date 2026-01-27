package com.bootcamp.demo.bc_mtr_station.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_mtr_station.dto.MtrDto;
import com.bootcamp.demo.bc_mtr_station.repository.MtrRepository;

@Service
public class MtrServiceImpl {
  @Autowired
  private MtrRepository mtrRepository;

  @Override
  MtrDto getStation(String name) {
    return this.mtrRepository.findByName(name);
  }
}
