package com.promineotech.speech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.speech.dao.CreateUserDao;
import com.promineotech.speech.entity.Users;

@Service
public class DefaultCreateUserService implements CreateUserService {

  @Autowired
  private CreateUserDao createUserDao;


  @Transactional
  @Override
  public Users createUser(String firstName, String lastName, String email, String state) {
    return createUserDao.saveUser(firstName, lastName, email, state);
  }
}

