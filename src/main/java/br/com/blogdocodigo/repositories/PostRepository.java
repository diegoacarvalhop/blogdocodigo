package br.com.blogdocodigo.repositories;

import java.util.List;

import br.com.blogdocodigo.entities.Post;

public interface PostRepository {

    void save(Post post);

    void update(Post post);

    void delete(Long id);

    Post findById(Long id);

    List<Post> findAll();

    List<Post> findByTitle(String title);

    List<Post> findByAuthor(String author);

    List<Post> findByCategoryId(Long id);

}
