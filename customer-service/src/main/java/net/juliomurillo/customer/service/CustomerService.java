package net.juliomurillo.customer.service;

import java.util.List;

import net.juliomurillo.customer.repository.entity.Customer;
import net.juliomurillo.customer.repository.entity.Region;

public interface CustomerService {

    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public  Customer getCustomer(Long id);



}