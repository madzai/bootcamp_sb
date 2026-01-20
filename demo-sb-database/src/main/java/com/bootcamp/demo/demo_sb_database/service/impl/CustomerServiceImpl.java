package com.bootcamp.demo.demo_sb_database.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_database.repository.CustomerRepository;
import com.bootcamp.demo.demo_sb_database.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerRepository customerRepository;
  // ! save/saveAll -> insert/update
  // ! findById/findAll -> select
  // ! deleteById -> delete

  @Override
  public CustomerEntity getById(Long id) {
    return this.customerRepository.findById(id).orElse(null); // Optional return type
  }

  @Override
  public CustomerEntity create(CustomerEntity customerEntity) {
    return this.customerRepository.save(customerEntity);
  }

  @Override
  public void deleteById(Long id) {
    this.customerRepository.deleteById(id);
  }

  @Override
  public CustomerEntity updateById(Long id, CustomerEntity customerEntity) {
    return this.customerRepository.findById(id) //
        .map(entity -> {
          entity.setDob(customerEntity.getDob());
          entity.setEmail(customerEntity.getEmail());
          entity.setName(customerEntity.getName());
          return this.customerRepository.save(customerEntity); // ! insert into
        }).orElse(null);
  }
}
