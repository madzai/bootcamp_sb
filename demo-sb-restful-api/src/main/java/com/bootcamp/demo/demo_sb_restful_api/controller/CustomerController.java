package com.bootcamp.demo.demo_sb_restful_api.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_sb_restful_api.model.Customer;
import com.bootcamp.demo.demo_sb_restful_api.model.Database;

@Controller
@ResponseBody
public class CustomerController {
  // Customer: name, dob, email

  // POST a customer
  @PostMapping(value = "/customer")
  public Customer addCustomer(@RequestBody Customer customer) {
    return Database.customers.add(customer) ? customer : null;
  }

  // GET all customers
  @GetMapping(value = "/customers")
  public List<Customer> getCustomers() {
    return Database.customers;
  }

  // GET customer by index
  @GetMapping(value = "/customer")
  public Customer getNameByIndex(@RequestParam Integer index) {
    return Database.customers.get(index);
  }

  // DELETE by name
  @DeleteMapping(value = "/customer")
  public boolean deleteCustomer(@RequestParam String name) {
    return Database.customers.removeIf(e -> e.getName().equals(name));
  }

}
