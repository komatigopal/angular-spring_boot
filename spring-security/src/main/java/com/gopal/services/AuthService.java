package com.gopal.services;

import com.gopal.dto.SignupRequest;
import com.gopal.entities.Customer;
import com.gopal.entities.Role;

import java.util.List;

public interface AuthService {

    List<Role> getRoles() throws Exception;
}
