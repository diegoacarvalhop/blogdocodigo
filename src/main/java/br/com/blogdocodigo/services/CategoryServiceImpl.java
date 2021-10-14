package br.com.blogdocodigo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.blogdocodigo.entities.Category;
import br.com.blogdocodigo.repositories.CategoryRepository;

@Service
@Transactional(readOnly = false)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void edit(Category category) {
        repository.update(category);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean categoryHavePosts(Long id) {
        if(findById(id).getPosts().isEmpty()) {
            return false;
        }
        return true;
    }

	@Override
	public long findByName(String nome) {
		return repository.findByName(nome);
	}

}
