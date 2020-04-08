package br.com.blogdocodigo.repository;

import java.util.List;

import br.com.blogdocodigo.model.Post;
import br.com.blogdocodigo.util.PaginacaoUtil;

public interface PostRepository {

    void save(Post post);

    void update(Post post);

    void delete(Long id);

    Post findById(Long id);

    List<Post> findAll();

    List<Post> findByTitulo(String titulo);

    List<Post> findByAutor(String autor);

    List<Post> findByCategoriaId(Long id);

	List<Post> findAllHome();

	PaginacaoUtil<Post> buscaPaginada(int pagina);

}
