package com.promineotech.speech.dao;

import com.promineotech.speech.entity.Users;

public interface CreateUserDao {

  Users saveUser(String firstName, String lastName, String email, String state);

}


