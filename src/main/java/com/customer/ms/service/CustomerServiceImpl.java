package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CustomerM> findAll(){
		return customerRepository.findAll();
	}
	
	@Override
	public String deleteById(String cusId) {
		customerRepository.deleteById(cusId);
		return "Delete Successful for Customer Id" + cusId;
	}

	@Override
	public CustomerM findById(String cusId) {
		
		Optional<CustomerM> customerM = customerRepository.findById(cusId);
		if(customerM.isPresent()) {
			return customerM.get();
		}
		return null;
	}

	@Override
	public CustomerM addCustomer(CustomerM customerM) {
		return customerRepository.save(customerM);
	}

	@Override
	public String updateCustomer(CustomerM customerM) {
		Optional<CustomerM> cust = customerRepository.findById(customerM.getCusId());
		if(cust.isPresent()) {
			customerRepository.save(customerM);
			return "Mongo Customer Updated";
		}
		return "Mongo Customer Not Found";
	}
	
	
}
