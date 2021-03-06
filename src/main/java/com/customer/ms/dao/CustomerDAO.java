package com.customer.ms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.customer.ms.model.Customer;

@Repository
public class CustomerDAO {

	private static final Map<String, Customer> cusMap = new HashMap<String, Customer>();

	static {
		initCus();
	}

	private static void initCus() {
		Customer cus1 = new Customer("C01", "Rohit", "FL");
		Customer cus2 = new Customer("C02", "RG", "MO");
		Customer cus3 = new Customer("C03", "Goyal", "TX");
		cusMap.put(cus1.getCusId(), cus1);
		cusMap.put(cus2.getCusId(), cus2);
		cusMap.put(cus3.getCusId(), cus3);
	}

	public Customer getCustomer(String cusId) {
		return cusMap.get(cusId);
	}

	public List<Customer> getAllCustomers() {
		Collection<Customer> cus = cusMap.values();
		List<Customer> list = new ArrayList<Customer>();
		list.addAll(cus);
		return list;
	}

	public Customer addCustomer(Customer cus) {
		cusMap.put(cus.getCusId(), cus);
		return cus;
	}
	
	public String deleteCustomer(String cusId) {
		Customer deletedCus = cusMap.remove(cusId);
		return deletedCus.getCusId();
		
	}
	
	public String updateCustomer(Customer cus) {
		cusMap.replace(cus.getCusId(), cus);
		return "Update Successful";
	}

}
