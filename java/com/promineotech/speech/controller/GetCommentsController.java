package com.promineotech.speech.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.speech.entity.Comments;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated // turns bean validation on
@RequestMapping("/getcomments")
@OpenAPIDefinition(info = @Info(title = "MySpeech Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})


public interface GetCommentsController {


  @Operation(

      summary = "Returns a list of comments.",
      description = "Returns a list of comments given a user's id.",

      responses = {
          @ApiResponse(responseCode = "200", description = "A list of comments is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Comments.class))),
          @ApiResponse(responseCode = "400", description = "Request paramaters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No comments were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },

      parameters = {
          @Parameter(name = "userId", allowEmptyValue = false, required = false,
              description = "The user's id (i.e., '1')"),
      }

  )

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Comments> fetchComments(@RequestParam(required = false) int userId);

}


