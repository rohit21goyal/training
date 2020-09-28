package com.customer.ms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;

@RestController
public class CustomerController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Greetings from Sring Boot 1.0";
	}
	
	@Autowired
	private CustomerDAO cusDAO;
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomer(@PathVariable("id") String id) {
		return cusDAO.getCustomer(id);
		
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return cusDAO.getAllCustomers();
	}
	
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer cus) {
		return cusDAO.addCustomer(cus);
				
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable("id") String id) {
		return cusDAO.deleteCustomer(id);
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customer cus) {
		return cusDAO.updateCustomer(cus);
		
	}

}