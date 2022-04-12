package com.promineotech.speech.controller;

import java.util.List;
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


@Validated // turns bean validation on
@RequestMapping("/users")
@OpenAPIDefinition(info = @Info(title = "MySpeech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface SpeechUsersController {

  @Operation(

      summary = "Returns a list of users.",
      description = "Returns a list of users given a user's state of residence.",

      responses = {
          @ApiResponse(responseCode = "200", description = "A list of users is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No users were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))},

      parameters = {@Parameter(name = "state", allowEmptyValue = false, required = false,
          description = "The user's state (i.e., 'Florida')"),}

  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Users> fetchUsers(@RequestParam(required = false) String state);

}


