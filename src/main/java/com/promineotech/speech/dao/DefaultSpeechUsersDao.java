package com.promineotech.speech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.speech.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j


public class DefaultSpeechUsersDao implements SpeechUsersDao {
  
  
  //inject a jdbctemplate at runtime
   @Autowired
   private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public List<Users> fetchUsers(String state) {
    log.debug("DAO: state={}", state);
    String sql = "SELECT * FROM users WHERE state = :state";
    Map <String, Object> params = new HashMap <>();
//you can use RowMapper or Row Dataset Extractor. you use RowMapper when you are returning
//a list. its able to infer that you're returning a list of jeeps from the return stmnt ao you don't have to add "Jeep" to it
//RowMapper maps rows of a ResultSet (query data results) on a per-row basis.      
//remember the jdbc template helps prevent sql injection with use of colons   
//create a map where you can pass in your jdbc template
    params.put("state", state);
    return jdbcTemplate.query(sql,  params, new RowMapper<>() {
      
      @Override
      public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Users.builder()
            .id(rs.getInt("id"))
            .firstName(rs.getString("first_name"))
            .lastName(rs.getString("last_name"))
            .email(rs.getString("email"))
            .state(rs.getString("state"))
            .build();
            
      }} );
      
    
   
    
  }

}
