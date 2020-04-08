package br.com.blogdocodigo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.blogdocodigo.model.Categoria;
import br.com.blogdocodigo.util.PaginacaoUtil;

@Repository
public class CategoriaRepositoryImpl extends AbstractRepository<Categoria, Long> implements CategoriaRepository {

	public PaginacaoUtil<Categoria> buscaPaginada(int pagina, String direcao) {
		int tamanho = 10;
		int inicio = (pagina - 1) * tamanho; // 0*5=0 1*5=5 2*5=10
		List<Categoria> categorias = getEntityManager()
				.createQuery("select c from Categoria c order by c.nome " + direcao, Categoria.class)
				.setFirstResult(inicio).setMaxResults(tamanho).getResultList();

		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

		List<Integer> numerosPaginas = new ArrayList<>();

		for (int x = 0; x < totalDePaginas; x++) {
			numerosPaginas.add(x + 1);
		}

		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, categorias, numerosPaginas);
	}

	public long count() {
		return getEntityManager().createQuery("select count(*) from Categoria", Long.class).getSingleResult();
	}

	@Override
	public long findByNome(String nome) {
		return getEntityManager()
				.createQuery("select count(*) from Categoria c where c.nome = '" + nome + "'", Long.class)
				.getSingleResult();
	}

}
