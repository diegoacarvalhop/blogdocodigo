package br.com.blogdocodigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.blogdocodigo.model.Post;
import br.com.blogdocodigo.repository.PostRepository;
import br.com.blogdocodigo.util.PaginacaoUtil;

@Service
@Transactional(readOnly = false)
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;

	@Override
	public void salvar(Post post) {
		repository.save(post);
	}

	@Override
	public void editar(Post post) {
		repository.update(post);
	}

	@Override
	public void excluir(Long id) {
		repository.delete(id);
	}

	@Override
	public Post buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Post> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public List<Post> buscarPorTitulo(String titulo) {
		List<Post> posts = repository.findByTitulo(titulo);
		return posts;
	}

	@Override
	public List<Post> buscarPorAutor(String autor) {
		return repository.findByTitulo(autor);
	}

	@Override
	public List<Post> buscarPorCategoria(Long id) {
		return repository.findByCategoriaId(id);
	}

	@Override
	public List<Post> buscarTodosHome() {
		return repository.findAllHome();
	}

	@Override
	public PaginacaoUtil<Post> buscarPorPagina(int pagina) {
		return repository.buscaPaginada(pagina);
	}

}
