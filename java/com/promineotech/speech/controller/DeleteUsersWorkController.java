package com.promineotech.speech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.speech.entity.Users;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated 
@RequestMapping("/delete_users_work")
@OpenAPIDefinition(info = @Info(title = "MySpeech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DeleteUsersWorkController {

  @Operation(

      summary = "Deletes item from users_work.",
      description = "Deletes items from the users_work table given a user's primary id.",

      responses = {
          @ApiResponse(responseCode = "200", description = "Users_work is deleted.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No items were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },

      parameters = {
          @Parameter(name = "id", allowEmptyValue = false, required = false,
              description = "The user's id (i.e., '1')"),
      }

  )

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteUsersWorkById(@RequestParam(required = false) int id);
  // @Pattern regex "[]\\w\\s]*"with used for passwords, typically---
}


