package com.promineotech.speech.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.speech.dao.SpeechUsersDao;
import com.promineotech.speech.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultSpeechUsersService implements SpeechUsersService {
  
  @Autowired
  private SpeechUsersDao speechUsersDao;
  
  
  @Transactional
  @Override
  public List<Users> fetchUsers(String state) {
    log.info("The fetchUsers method was called with state={}", state);
    List<Users> users = speechUsersDao.fetchUsers(state);
    if(users.isEmpty()) {
      String msg = String.format("No users were found with state=%s", state);
      throw new NoSuchElementException(msg);
    }
        
    return users;
  }
  

}
