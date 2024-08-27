package com.gopal.services;

import com.gopal.dto.SignupRequest;
import com.gopal.entities.Customer;
import com.gopal.entities.Role;
import com.gopal.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoAuthServiceImpl implements NoAuthService{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Customer createCustomer(SignupRequest signupRequest) throws Exception{
        if (customerRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }

        List<Role> roles = new ArrayList<>();
        for(String role:signupRequest.getRoles()){
            roles.add(new Role(role));
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(signupRequest,customer);
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setEmail(customer.getEmail().toLowerCase());
        customer.setPassword(hashPassword);
        customer.setRoles(roles);
        Customer createdCustomer = customerRepository.save(customer);
        customer.setId(createdCustomer.getId());
        logger.info("customer - {}", customer);
        return customer;
    }
}
