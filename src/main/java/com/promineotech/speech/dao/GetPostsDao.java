package com.promineotech.speech.dao;

import java.util.List;
import com.promineotech.speech.entity.Posts;

public interface GetPostsDao {
  
  List<Posts> fetchPosts (int userId);

}
