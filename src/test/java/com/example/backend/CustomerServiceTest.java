package com.example.backend;


import com.example.backend.Service.CustomerService;
import com.example.backend.controllers.CustomerController;
import com.example.backend.model.Customer;
import com.example.backend.model.CustomerNoPwd;
import com.example.backend.repositories.CustomerRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository; // Mock veut dire que je n'utilise pas la bd

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        //cette méthode permet de réinitialiser les données avant chaque test
    }

    @Test
    public void testFindALlUser() {

        //Arrange : préparer les données de test
        Customer c = new Customer();
        c.setEmail("1");
        List<Customer> list = Arrays.asList(c);

        //return une liste données au lieu de faire une requette sql dans une bd
        when(customerRepository.findAll()).thenReturn(list);
        List<CustomerNoPwd> result = customerService.getallCustomer();
        //Act appel la méthode que tu veux tester
        assertEquals("1", list.get(0).getEmail());

    }
}
