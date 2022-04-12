package com.promineotech.speech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.speech.entity.Users;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/updateuser")
@OpenAPIDefinition(info = @Info(title = "MySpeech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})


public interface UpdateUserController {


  @Operation(

      summary = "Updates a user's information.",
      description = "Returns an updated user when provided with their id.",

      responses = {
          @ApiResponse(responseCode = "200",
              description = "You have returned a user with updated information.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No users were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))

      }


  )

  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Users updateUserById(@RequestBody Users user, @RequestParam(required = false) int id);
  // Method parameters annotated with @RequestParam are required by default.
  // This means that if the parameter isn’t present in the request, we'll get an error:
  // We can configure our @RequestParam to be optional, though, with the required attribute:,
  // REQUIRED = FALSE

}


