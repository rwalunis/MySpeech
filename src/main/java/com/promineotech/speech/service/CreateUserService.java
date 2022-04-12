package com.promineotech.speech.service;


import com.promineotech.speech.entity.Users;

public interface CreateUserService {

Users createUser(String firstName, String lastName, String email, String state);

}
