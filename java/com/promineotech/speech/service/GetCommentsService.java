package com.promineotech.speech.service;

import java.util.List;
import com.promineotech.speech.entity.Comments;

public interface GetCommentsService {

  List<Comments> fetchComments(int userId);

}
