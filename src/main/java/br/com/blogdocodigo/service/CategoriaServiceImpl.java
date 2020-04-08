package br.com.blogdocodigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.blogdocodigo.model.Categoria;
import br.com.blogdocodigo.repository.CategoriaRepository;
import br.com.blogdocodigo.util.PaginacaoUtil;

@Service
@Transactional(readOnly = false)
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public void salvar(Categoria categoria) {
        repository.save(categoria);
    }

    @Override
    public void editar(Categoria categoria) {
        repository.update(categoria);
    }

    @Override
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Categoria> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean categoriaTemPosts(Long id) {
        if(buscarPorId(id).getPosts().isEmpty()) {
            return false;
        }
        return true;
    }

	@Override
	public PaginacaoUtil<Categoria> buscarPorPagina(int pagina, String direcao) {
		return repository.buscaPaginada(pagina, direcao);
	}

	@Override
	public long buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

}
