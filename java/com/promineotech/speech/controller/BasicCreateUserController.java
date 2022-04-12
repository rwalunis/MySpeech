package com.promineotech.speech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.entity.Users;
import com.promineotech.speech.service.CreateUserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class BasicCreateUserController implements CreateUserController {

  @Autowired
  private CreateUserService createUserService;


  @Override
  public Users createUser(String firstName, String lastName, String email, String state) {
    log.debug("first_name = {}, last_name = {}, email = {}, state = {}", firstName, lastName, email,
        state);
    return createUserService.createUser(firstName, lastName, email, state);

  }
}


