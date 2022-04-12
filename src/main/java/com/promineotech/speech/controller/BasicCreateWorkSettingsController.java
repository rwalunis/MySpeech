package com.promineotech.speech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.entity.WorkSettings;
import com.promineotech.speech.service.CreateWorkSettingsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class BasicCreateWorkSettingsController implements CreateWorkSettingsController {

  @Autowired
  private CreateWorkSettingsService createWorkSettingsService;



  @Override
  public WorkSettings createWorkSettings(String workDescription) {
    log.debug("work_description = {}", workDescription);
    return createWorkSettingsService.createWorkSettings(workDescription);
  }
}

