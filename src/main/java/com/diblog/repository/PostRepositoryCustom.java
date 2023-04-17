package com.diblog.repository;

import com.diblog.domain.Post;
import com.diblog.request.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}
