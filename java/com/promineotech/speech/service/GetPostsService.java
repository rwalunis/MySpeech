package com.promineotech.speech.service;

import java.util.List;
import com.promineotech.speech.entity.Posts;

public interface GetPostsService {

  List<Posts> fetchPosts(int userId);

}


