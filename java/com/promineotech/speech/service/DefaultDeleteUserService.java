package com.promineotech.speech.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class DefaultDeleteUserService implements DeleteUserService {

  @Transactional
  @Override
  public void deleteUserById(int id) {

  }

}
