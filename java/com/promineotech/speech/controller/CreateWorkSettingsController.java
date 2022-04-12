package com.promineotech.speech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.speech.entity.WorkSettings;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/createworksettings")
@OpenAPIDefinition(info = @Info(title = "Speech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})

public interface CreateWorkSettingsController {

  @Operation(

      summary = "Create a new work setting.", description = "Return the created work setting.",

      responses = {

          @ApiResponse(responseCode = "201", description = "A new work setting is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = WorkSettings.class))),

          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),

          @ApiResponse(responseCode = "404",
              description = "No work setting exists with the given input criteria.",
              content = @Content(mediaType = "application/json")),

          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))

      },

      parameters = {



          @Parameter(name = "workDescription", allowEmptyValue = false, required = false,
              description = "Name of desired work setting (i.e., 'prn hospital')"),

      })


  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  WorkSettings createWorkSettings(@RequestParam(required = false) String workDescription);

}
