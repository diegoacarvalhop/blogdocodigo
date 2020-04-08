package br.com.blogdocodigo.service;

import java.util.List;

import br.com.blogdocodigo.model.Categoria;
import br.com.blogdocodigo.util.PaginacaoUtil;

public interface CategoriaService {

    void salvar(Categoria categoria);

    void editar(Categoria categoria);

    void excluir(Long id);

    Categoria buscarPorId(Long id);

    List<Categoria> buscarTodos();
    
    long buscarPorNome(String nome);

    boolean categoriaTemPosts(Long id);

    public PaginacaoUtil<Categoria> buscarPorPagina(int pagina, String direcao);
    
}
