package com.bootcamp.demo.demo_sb_database.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_database.entity.CustomerEntity;

@Service
public interface CustomerService {
  CustomerEntity getById(Long id);

  CustomerEntity create(CustomerEntity customEntity);

  void deleteById(Long id);

  CustomerEntity updateById(Long id, CustomerEntity customerEntity);

}
