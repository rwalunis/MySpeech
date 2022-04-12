package com.promineotech.speech.dao;

import java.util.List;
import com.promineotech.speech.entity.Users;

public interface SpeechUsersDao {
  
  List<Users> fetchUsers (String state);

}
