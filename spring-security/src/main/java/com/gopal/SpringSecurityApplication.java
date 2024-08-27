package com.gopal;

import com.gopal.entities.Customer;
import com.gopal.entities.Role;
import com.gopal.repository.CustomerRepository;
import com.gopal.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Role role = new Role();
//        role.setRole("admin");
//
//        Customer customer1 = new Customer();
//        customer1.setEmail("admin".toLowerCase());
//        customer1.setName("admin");
//        customer1.setPassword(passwordEncoder.encode("admin"));
//        customer1.setRoles(Arrays.asList(role));
//        customerRepository.save(customer1);
//        for (Customer customer : customerRepository.findAll()) {
//            logger.info("customer - {}", customer);
//        }
    }
}
