package br.com.blogdocodigo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.blogdocodigo.model.Post;
import br.com.blogdocodigo.util.PaginacaoUtil;

@Repository
public class PostRepositoryImpl extends AbstractRepository<Post, Long> implements PostRepository {

    @Override
    public List<Post> findByTitulo(String titulo) {
        return createQuery("select p from Post p where p.titulo like concat('%', ?1, '%')", titulo);
    }

    @Override
    public List<Post> findByAutor(String autor) {
        return createQuery("select p from Post p where p.autor like concat('%', ?1, '%')", autor);
    }

    @Override
    public List<Post> findByCategoriaId(Long id) {
        return createQuery("select p from Post p where p.categoria.id = ?1", id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Post> findAllHome() {
    	return getEntityManager().createQuery("select p from Post p order by p.id desc").setMaxResults(3).getResultList();
    }

	public PaginacaoUtil<Post> buscaPaginada(int pagina) {
		int tamanho = 2;
		int inicio = (pagina - 1) * tamanho; // 0*5=0 1*5=5 2*5=10
		List<Post> posts = getEntityManager()
				.createQuery("select p from Post p order by p.id asc", Post.class)
				.setFirstResult(inicio).setMaxResults(tamanho).getResultList();

		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

		List<Integer> numerosPaginas = new ArrayList<>();

		for (int x = 0; x < totalDePaginas; x++) {
			numerosPaginas.add(x + 1);
		}

		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, posts, numerosPaginas);
	}
	
	public long count() {
		return getEntityManager().createQuery("select count(*) from Post", Long.class).getSingleResult();
	}
	
}
