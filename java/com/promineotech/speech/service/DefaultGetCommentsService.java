package com.promineotech.speech.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.speech.dao.GetCommentsDao;
import com.promineotech.speech.entity.Comments;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultGetCommentsService implements GetCommentsService {

  @Autowired
  private GetCommentsDao getCommentsDao;
  
 

  @Transactional
  @Override
  public List<Comments> fetchComments(int userId) {
    log.info("The fetchComments method was called with user_id={}", userId);
    List <Comments> comments = getCommentsDao.fetchComments(userId);
    if(comments.isEmpty()) {
      String msg = String.format("No comments were found with user_id=%s", userId);
      throw new NoSuchElementException(msg);
    }
    return comments;
  }
  

}
