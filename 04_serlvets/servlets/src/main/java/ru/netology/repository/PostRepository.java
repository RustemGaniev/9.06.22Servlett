package ru.netology.repository;

import ru.netology.model.Post;


import java.util.*;


public class PostRepository {
  private Map<Long, Post> posts = new HashMap<>();
  private long id = 1;
  public List<Post> all() {

    return new ArrayList<>(posts.values());
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(posts.get(id));
  }

  public synchronized Post save(Post post) {
    Post newPost = new Post(id, post.getContent());
    post.setId(id);
    posts.put(id, newPost);
    id++;
    return newPost;
  }

  public synchronized void removeById(long id) {
    posts.remove(id);
  }
}
