package com.promineotech.speech.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.entity.Users;
import com.promineotech.speech.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicUserController implements UserController {

  @Autowired
  private UserService userService;

  @Override
  public Optional<Users> getUserById(int id) {
    log.info("id = {}", id);
    return userService.getUserById(id);
  }

}
