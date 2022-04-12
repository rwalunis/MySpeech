package com.promineotech.speech.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.speech.dao.GetPostsDao;
import com.promineotech.speech.entity.Posts;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultGetPostsService implements GetPostsService {
  
  @Autowired
  private GetPostsDao getPostsDao;
  
  @Transactional
  @Override
  public List<Posts> fetchPosts(int userId) {
    log.info("The fetchPosts method was called with user_id={}", userId);
    List <Posts> posts = getPostsDao.fetchPosts(userId);
    if(posts.isEmpty()) {
      String msg = String.format("No posts were found with user_id=%s", userId);
      throw new NoSuchElementException(msg);
    }
    return posts;
  } 

}
