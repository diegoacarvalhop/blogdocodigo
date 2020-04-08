package br.com.blogdocodigo.service;

import java.util.List;

import br.com.blogdocodigo.model.Post;
import br.com.blogdocodigo.util.PaginacaoUtil;

public interface PostService {

    void salvar(Post post);

    void editar(Post post);

    void excluir(Long id);

    Post buscarPorId(Long id);

    List<Post> buscarTodos();

    List<Post> buscarPorTitulo(String titulo);

    List<Post> buscarPorAutor(String autor);

    List<Post> buscarPorCategoria(Long id);
    
    List<Post> buscarTodosHome();

	PaginacaoUtil<Post> buscarPorPagina(int paginaAtual);

}
