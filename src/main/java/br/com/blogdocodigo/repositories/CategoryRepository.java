package br.com.blogdocodigo.repositories;

import java.util.List;

import br.com.blogdocodigo.entities.Category;

public interface CategoryRepository {

	void save(Category category);

	void update(Category category);

	void delete(Long id);

	Category findById(Long id);
	
	long findByName(String nome);

	List<Category> findAll();

}
