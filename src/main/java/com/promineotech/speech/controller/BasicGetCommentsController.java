package com.promineotech.speech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.entity.Comments;
import com.promineotech.speech.service.GetCommentsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicGetCommentsController implements GetCommentsController {

  @Autowired
  private GetCommentsService getCommentsService;

  @Override
  public List<Comments> fetchComments(int userId) {
    log.info("userId = {}", userId);
    return getCommentsService.fetchComments(userId);
  }

}
