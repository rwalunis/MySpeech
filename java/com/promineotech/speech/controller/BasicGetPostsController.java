package com.promineotech.speech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.speech.entity.Posts;
import com.promineotech.speech.service.GetPostsService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class BasicGetPostsController implements GetPostsController {

  @Autowired
  private GetPostsService getPostsService;

  @Override
  public List<Posts> fetchPosts(int userId) {
    log.info("userId = {}", userId);
    return getPostsService.fetchPosts(userId);
  }

}
