package br.com.blogdocodigo.services;

import br.com.blogdocodigo.entities.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    void edit(Category category);

    void delete(Long id);

    Category findById(Long id);

    List<Category> findAll();
    
    long findByName(String nome);

    boolean categoryHavePosts(Long id);

}
