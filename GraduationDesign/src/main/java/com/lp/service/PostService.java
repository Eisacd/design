package com.lp.service;

import com.lp.dto.Result;
import com.lp.entity.Post;

public interface PostService {

    Result getPersonForPost();

    Result getPersonForOnePost(Post post);
}
