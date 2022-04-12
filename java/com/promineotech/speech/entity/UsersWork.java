package com.promineotech.speech.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UsersWork {
  
  private int workId;
  private int userId;

}
