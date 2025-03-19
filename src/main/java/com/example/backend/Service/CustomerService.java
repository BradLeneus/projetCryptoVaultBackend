package com.example.backend.Service;

import com.example.backend.model.Customer;
import com.example.backend.model.CustomerNoPwd;
import com.example.backend.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerNoPwd> getallCustomer(){
        List<CustomerNoPwd> customerNoPwdList = new ArrayList<>();
        List<Customer> listCustomer = customerRepository.findAll();
        for(Customer c : listCustomer){
            CustomerNoPwd customerNoPwd = new CustomerNoPwd();
            customerNoPwd.setId(c.getId());
            customerNoPwd.setFname(c.getFname());
            customerNoPwd.setEmail(c.getEmail());

            customerNoPwdList.add(customerNoPwd);
        }
        return customerNoPwdList;
    }
    public boolean createCustomer(Customer customer){

        customerRepository.save(customer);
        return true;
    }

    public CustomerNoPwd findCustomerByNameAndPassword(String name, String lname){
        List<Customer> arr = customerRepository.findAll();

        for (Customer c : arr){
            if (c.getFname().equals(name) && c.getLname().equals(lname)){
                CustomerNoPwd customerNoPwd = new CustomerNoPwd();
                customerNoPwd.setId(c.getId());
                customerNoPwd.setFname(c.getFname());
                customerNoPwd.setEmail(c.getEmail());
                return customerNoPwd;
            }


        }
        return null;
    }
    public CustomerNoPwd findCustomerById(int id){
        Optional<Customer> c = customerRepository.findById(id);
        CustomerNoPwd customerNoPwd = new CustomerNoPwd();
        customerNoPwd.setId(c.get().getId());
        customerNoPwd.setEmail(c.get().getEmail());
        customerNoPwd.setFname(c.get().getFname());
        return customerNoPwd;
    }
}
