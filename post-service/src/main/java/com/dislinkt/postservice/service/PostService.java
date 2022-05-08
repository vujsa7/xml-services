package com.dislinkt.postservice.service;

import com.dislinkt.postservice.model.Post;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostService {
    void save(Post post);
    List<Post> findUserPosts(String userId);

    List<Post> getFeed(List<String>  connectionsIds);
}
