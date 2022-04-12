package com.promineotech.speech.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Posts {
  
  private int id;
  private int userId;
  private String postDescription;
 
}
