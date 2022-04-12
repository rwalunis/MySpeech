package com.promineotech.speech.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.speech.dao.UserDao;
import com.promineotech.speech.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultUserService implements UserService {
  
  
  
  @Autowired
  private UserDao userDao;
  
  
 

  @Transactional
  @Override
  public Optional<Users> getUserById(int id) {
    log.info("The getUserById method was called with id={}", id);
    Optional<Users> user = userDao.getUserById(id);
    if(user.isEmpty()) {
      String msg = String.format("No users were found with that id=%s", id);
      throw new NoSuchElementException(msg);
      
    }
    return user;
  }
  

}
