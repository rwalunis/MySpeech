package com.promineotech.speech.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
//DELETE THIS CLASS??????????????????
@Data

public class UsersRequest {
  
  @NotNull
  private int id;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")  
  private String firstName;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")  
  private String lastName;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")  
  private String email;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")  
  private String state;

}
