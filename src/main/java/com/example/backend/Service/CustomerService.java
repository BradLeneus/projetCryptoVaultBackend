package com.example.backend.Service;

import com.example.backend.model.Customer;
import com.example.backend.model.CustomerNoPwd;
import com.example.backend.repositories.CustomerRepository;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
        if(customerRepository.findCustomersByFname(customer.getFname()) == null){
            customer.setLname(passwordEncoder.encode(customer.getLname()));
            customerRepository.save(customer);
            return true;
        }
        else {
            return false;
        }

    }

    public CustomerNoPwd findCustomerByNameAndPassword(String name, String lname){
        Customer c = customerRepository.findCustomersByFname(name);


            if (passwordEncoder.matches(lname, c.getLname())){
                CustomerNoPwd customerNoPwd = new CustomerNoPwd();
                customerNoPwd.setId(c.getId());
                customerNoPwd.setFname(c.getFname());
                customerNoPwd.setEmail(c.getEmail());
                return customerNoPwd;
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
    public void deleteCustomerById(int id){
        customerRepository.deleteById(id);
    }
    public boolean isUserExistByCustomerName(String name){
        Customer customer = customerRepository.findCustomersByFname(name);
        if(customer != null){
            return true;
        }

        return false;
    }
}
