package com.promineotech.speech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/createuser")
@OpenAPIDefinition(info = @Info(title = "Speech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface CreateUserController {

  @Operation(

      summary = "Create a new user.", description = "Return the created user.",

      responses = {

          @ApiResponse(responseCode = "201", description = "A created user is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),

          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),

          @ApiResponse(responseCode = "404",
              description = "No user exists with the given input criteria.",
              content = @Content(mediaType = "application/json")),

          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))

      },

      parameters = {



          @Parameter(name = "firstName", allowEmptyValue = false, required = false,
              description = "The user's first name (i.e., 'Ashley')"),

          @Parameter(name = "lastName", allowEmptyValue = false, required = false,
              description = "The user's last name (i.e., 'White')"),

          @Parameter(name = "email", allowEmptyValue = false, required = false,
              description = "The user's email (i.e., 'awhite@sbcglobal.net')"),

          @Parameter(name = "state", allowEmptyValue = false, required = false,
              description = "The user's state of residence (i.e., 'Ohio')")


      })

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Users createUser(@RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName, @RequestParam(required = false) String email,
      @RequestParam(required = false) String state);


}


