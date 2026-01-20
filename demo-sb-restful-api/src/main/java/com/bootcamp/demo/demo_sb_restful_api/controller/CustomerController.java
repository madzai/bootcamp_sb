package com.bootcamp.demo.demo_sb_restful_api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_sb_restful_api.model.Customer;
import com.bootcamp.demo.demo_sb_restful_api.model.Database;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@ResponseBody
public class CustomerController {
  private static long customerIdCounter = 0;
  // Customer: name, dob, email

  // POST a customer
  @PostMapping(value = "/customer")
  public Customer addCustomer(@RequestBody Customer customer) {
    customer.setId(++customerIdCounter);
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

  // GET customer by id
  @GetMapping(value = "/customer/{id}")
  public Customer getById(@PathVariable Long id) {
    return Database.customers.stream() //
        .filter(e -> e.getId().equals(id)) //
        .findAny() //
        .orElse(null);
  }

  // DELETE by name
  @DeleteMapping(value = "/customer")
  public boolean deleteCustomer(@RequestParam String name) {
    return Database.customers.removeIf(e -> e.getName().equals(name));
  }

  // PUT by id
  @PutMapping("/customer")
  public Customer updatedById(@RequestParam Long id,
      @RequestBody Customer customer) {
    if (!id.equals(customer.getId()))
      return null;
    // Optional is not necessary after id is checked to be present in customer list
    Optional<Customer> target = Database.customers.stream() //
        .filter(e -> e.getId().equals(id)) //
        .findAny();
    if (target.isPresent()
        && Database.customers.removeIf(e -> e.getId().equals(id))) {
      Database.customers.add(customer);
      return customer;
    }
    return null;
  }

  // PATCH by id
  @PatchMapping("/customer/email/{email}")
  public Customer patchEmailById(@PathVariable String email,
      @RequestParam Long id) {
    Optional<Customer> target = Database.customers.stream() //
        .filter(e -> e.getId().equals(id)) //
        .findAny();
    if (target.isPresent()) {
      Customer customer = target.get();
      customer.setEmail(email);
      // below are not needed, can set object's attribute
      // Database.customers.removeIf(e -> e.getId().equals(id));
      // Database.customers.add(customer);
      return customer;
    }
    return null;
  }

  // PATCH by dob
  @PatchMapping("/customer/dob/{dob}")
  public Customer patchDobById(@PathVariable LocalDate dob,
      @RequestParam Long id) {
    Optional<Customer> target = Database.customers.stream() //
        .filter(e -> e.getId().equals(id)) //
        .findAny();
    if (target.isPresent()) {
      Customer customer = target.get();
      customer.setDob(dob);
      return customer;
    }
    return null;
  }

  ////////////////////////////////////////////////////////
  // POST a list customers
  @PostMapping(value = "/customers")
  public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
    for (Customer customer : customers) {
      customer.setId(++customerIdCounter);
      Database.customers.add(customer);
    }
    return customers;
  }

  @PatchMapping("/customer")
  public Customer patchCustomer(@RequestBody Customer newCustomer,
      @RequestParam Long id) {
    if (newCustomer == null)
      return null;
    Optional<Customer> target = Database.customers.stream() //
        .filter(e -> e.getId().equals(id)) //
        .findAny();
    if (target.isPresent()) {
      Customer customer = target.get();
      customer.setName(newCustomer.getName());
      customer.setDob((newCustomer.getDob()));
      customer.setEmail(newCustomer.getEmail());
      return customer;
    }
    return null;
  }

}
