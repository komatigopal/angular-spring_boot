package com.gopal.services;

import com.gopal.dto.SignupRequest;
import com.gopal.entities.Customer;
import com.gopal.entities.Role;
import com.gopal.repository.CustomerRepository;
import com.gopal.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() throws Exception {
        return roleRepository.findAll();
    }
}
