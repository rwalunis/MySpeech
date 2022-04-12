package com.promineotech.speech.dao;

import com.promineotech.speech.entity.WorkSettings;

public interface CreateWorkSettingsDao {
  
  WorkSettings saveWorkSettings (String workDescription);

}
