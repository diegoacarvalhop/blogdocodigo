package br.com.blogdocodigo.services;

import br.com.blogdocodigo.entities.Post;
import br.com.blogdocodigo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;

	@Override
	public void save(Post post) {
		repository.save(post);
	}

	@Override
	public void edit(Post post) {
		repository.update(post);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public Post findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Post> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Post> findByTitle(String title) {
		List<Post> posts = repository.findByTitle(title);
		return posts;
	}

	@Override
	public List<Post> findByAuthor(String author) {
		return repository.findByTitle(author);
	}

	@Override
	public List<Post> findByCategory(Long id) {
		return repository.findByCategoryId(id);
	}

}
