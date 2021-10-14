package br.com.blogdocodigo.services;

import br.com.blogdocodigo.entities.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    void edit(Post post);

    void delete(Long id);

    Post findById(Long id);

    List<Post> findAll();

    List<Post> findByTitle(String title);

    List<Post> findByAuthor(String author);

    List<Post> findByCategory(Long id);

}