package com.promineotech.speech.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service

public class DefaultDeleteUsersWorkDao implements DeleteUsersWorkDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public void deleteUsersWorkById(int userId) {
    String sql = "DELETE FROM users_work WHERE user_id = :user_id";
    Map<String, Object> params = new HashMap<>();
    params.put("user_id", userId);
    if (jdbcTemplate.update(sql, params) == 0)
      throw new NoSuchElementException();
  }

}

