package com.promineotech.speech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.entity.Users;
import com.promineotech.speech.service.SpeechUsersService;
import lombok.extern.slf4j.Slf4j;

    
@RestController   
@Slf4j
        
public class BasicSpeechUsersController implements SpeechUsersController{
  
@Autowired
private SpeechUsersService speechUsersService;

  @Override
  public List<Users> fetchUsers(String state) {
    log.info("state = {}", state);
   // return null;
    return speechUsersService.fetchUsers(state);
  }

}
