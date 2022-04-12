package com.promineotech.speech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.speech.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultUserDao implements UserDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void deleteUserById(int id) {
    String sql = "DELETE FROM users WHERE id = :id";
    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    if (jdbcTemplate.update(sql, params) == 0)
      throw new NoSuchElementException();

  }

  @Override
  public Optional<Users> getUserById(int id) {
    log.debug("DAO: id={}", id);
    String sql = "SELECT * FROM users WHERE id = :id";
    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new UsersResultSetExtractor()));
  }

  class UsersResultSetExtractor implements ResultSetExtractor<Users> {
    @Override
    public Users extractData(ResultSet rs) throws SQLException {
      rs.next();
      return Users.builder().id(rs.getInt("id")).firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name")).email(rs.getString("email"))
          .state(rs.getString("state")).build();

    }
  }

  @Override
  public Users updateUserById(Users user, int id) {
    String sql = "UPDATE users " + "SET first_name = :first_name," + " last_name = :last_name, "
        + "email = :email, " + "state = :state " + "WHERE id = :id";


    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("first_name", user.getFirstName());
    params.put("last_name", user.getLastName());
    params.put("email", user.getEmail());
    params.put("state", user.getState());

    if (jdbcTemplate.update(sql, params) == 0) {

      throw new NoSuchElementException("NoSuchElementException");

    } else {
      log.info("Update user succeeded");
    }
    return Users.builder().id(id).firstName(user.getFirstName()).lastName(user.getLastName())
        .email(user.getEmail()).state(user.getState()).build();
  }

}


