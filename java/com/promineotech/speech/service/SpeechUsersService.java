package com.promineotech.speech.service;

import java.util.List;
import com.promineotech.speech.entity.Users;

public interface SpeechUsersService {
   
  List<Users> fetchUsers (String state);
  
}

