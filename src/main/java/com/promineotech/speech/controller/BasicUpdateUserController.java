package com.promineotech.speech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.dao.UserDao;
import com.promineotech.speech.entity.Users;


@RestController

public class BasicUpdateUserController implements UpdateUserController {
  @Autowired
  private UserDao userDao;

  @Override
  public Users updateUserById(Users user, int id) {
          return userDao.updateUserById(user, id);
  }
}
  
