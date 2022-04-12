package com.promineotech.speech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.dao.DeleteUsersWorkDao;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class BasicDeleteUsersWork implements DeleteUsersWorkController {


  @Autowired
  private DeleteUsersWorkDao deleteUsersWorkDao;

  @Override
  public void deleteUsersWorkById(int id) {
    log.info("id = {}", id);
    deleteUsersWorkDao.deleteUsersWorkById(id);

  }

}
