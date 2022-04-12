package com.promineotech.speech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.speech.dao.CreateWorkSettingsDao;
import com.promineotech.speech.entity.WorkSettings;

@Service
public class DefaultCreateWorkSettingsService implements CreateWorkSettingsService {

  @Autowired
  private CreateWorkSettingsDao createWorkSettingsDao;


  @Transactional
  @Override
  public WorkSettings createWorkSettings(String workDescription) {
    return createWorkSettingsDao.saveWorkSettings(workDescription);
  }
}

