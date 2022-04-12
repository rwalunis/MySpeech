package com.promineotech.speech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicDeleteUserController implements DeleteUserController {

  @Autowired
  private UserDao userDao;

  @Override
  public void deleteUserById(int id) {
    log.info("id = {}", id);
    userDao.deleteUserById(id);

  }

}
