package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.CustomerRepository;
import com.example.MatrimonyManagement.service.CustomerService;

@Service
public class CustomerIMPL implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        try {

            return customerRepository.save(customer);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save customer due to database error");
        }
    }

    @Override
    public List<Customer> getAllCustomer() {

        try {

            return customerRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch customers due to database error");
        }
    }

    @Override
    public Customer getCustomerById(int id) {

        try {

            return customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch customer due to database error");
        }
    }

    @Override
    public void deleteCustomerById(int id) {

        try {

            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

            customerRepository.delete(customer);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete customer due to database error");
        }
    }

}