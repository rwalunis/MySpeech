package com.promineotech.speech.dao;

import java.util.List;
import com.promineotech.speech.entity.Comments;

public interface GetCommentsDao {
  
  List<Comments> fetchComments (int userId);

}
