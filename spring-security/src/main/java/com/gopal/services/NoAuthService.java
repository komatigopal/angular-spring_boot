package com.gopal.services;

import com.gopal.dto.SignupRequest;
import com.gopal.entities.Customer;

public interface NoAuthService {
    Customer createCustomer(SignupRequest signupRequest) throws Exception;
}
