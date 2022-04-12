package com.promineotech.speech.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Comments {
   
  private int id;
  private int postId;
  private int userId;
  private String commentDescription;

}
