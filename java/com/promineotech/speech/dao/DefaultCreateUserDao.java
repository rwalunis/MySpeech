package com.promineotech.speech.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.speech.entity.Users;

@Component
public class DefaultCreateUserDao implements CreateUserDao {

  private final String INSERT_SQL = "INSERT INTO users (first_name, last_name, email, state) "
      + "VALUES (:first_name, :last_name, :email, :state)";
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Users saveUser(String firstName, String lastName, String email, String state) {

    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource parameters = new MapSqlParameterSource().addValue("first_name", firstName)
        .addValue("last_name", lastName).addValue("email", email).addValue("state", state);
    jdbcTemplate.update(INSERT_SQL, parameters, keyHolder);

    int id = keyHolder.getKey().intValue();
    return Users.builder().id(id).firstName(firstName).lastName(lastName).email(email).state(state)
        .build();
  }
}
