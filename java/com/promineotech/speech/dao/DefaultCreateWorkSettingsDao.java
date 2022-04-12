package com.promineotech.speech.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.speech.entity.WorkSettings;

@Component
public class DefaultCreateWorkSettingsDao implements CreateWorkSettingsDao {


  private final String sql =
      "INSERT INTO work_settings (work_description) VALUES (:work_description)";

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public WorkSettings saveWorkSettings(String workDescription) {
    KeyHolder keyHolders = new GeneratedKeyHolder();
    SqlParameterSource parameters =
        new MapSqlParameterSource().addValue("work_description", workDescription);
    jdbcTemplate.update(sql, parameters, keyHolders);
    int id = keyHolders.getKey().intValue();
    return WorkSettings.builder().id(id).workDescription(workDescription).build();
  }
}

