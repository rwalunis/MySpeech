package com.promineotech.speech.dao;

import java.util.Optional;
import com.promineotech.speech.entity.Users;

public interface UserDao {

  void deleteUserById(int id);

  Optional<Users> getUserById(int id);

  Users updateUserById(Users user, int id);



}
