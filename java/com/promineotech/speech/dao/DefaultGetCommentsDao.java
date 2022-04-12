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
import com.promineotech.speech.entity.Comments;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultGetCommentsDao implements GetCommentsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  @Override
  public List<Comments> fetchComments(int userId) {
    log.debug("DAO: userId={}", userId);
    String sql = "SELECT * FROM comments WHERE user_id = :user_id";
    Map<String, Object> params = new HashMap<>();
    params.put("user_id", userId);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Comments.builder().id(rs.getInt("id")).postId(rs.getInt("post_id"))
            .userId(rs.getInt("user_id")).commentDescription(rs.getString("comment_description"))
            .build();

      }
    });

  }
}


