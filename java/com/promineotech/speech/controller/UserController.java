package com.promineotech.speech.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/a_user")
@OpenAPIDefinition(info = @Info(title = "MySpeech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserController {

  @Operation(

      summary = "Returns a single user.", description = "Returns a user given a user's primary id.",

      responses = {
          @ApiResponse(responseCode = "200", description = "A user is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No users were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))},

      parameters = {

          @Parameter(name = "id", allowEmptyValue = false, required = false,
              description = "The user's id (i.e., '1')"),

      }

  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Users> getUserById(@RequestParam(required = false) int id);

}


