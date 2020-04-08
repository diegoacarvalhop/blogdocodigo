package br.com.blogdocodigo.repository;

import java.util.List;

import br.com.blogdocodigo.model.Categoria;
import br.com.blogdocodigo.util.PaginacaoUtil;

public interface CategoriaRepository {

	void save(Categoria categoria);

	void update(Categoria categoria);

	void delete(Long id);

	Categoria findById(Long id);
	
	long findByNome(String nome);

	List<Categoria> findAll();

	PaginacaoUtil<Categoria> buscaPaginada(int pagina, String direcao);

}
