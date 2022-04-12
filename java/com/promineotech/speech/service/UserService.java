package com.promineotech.speech.service;

import java.util.Optional;
import com.promineotech.speech.entity.Users;

public interface UserService {

  Optional<Users> getUserById (int id);
  
  
}
