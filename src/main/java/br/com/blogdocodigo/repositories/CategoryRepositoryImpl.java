package br.com.blogdocodigo.repositories;

import br.com.blogdocodigo.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import br.com.blogdocodigo.entities.Category;

@Repository
public class CategoryRepositoryImpl extends AbstractRepository<Category, Long> implements CategoryRepository {

	public long count() {
		return getEntityManager().createQuery("select count(*) from Category", Long.class).getSingleResult();
	}

	@Override
	public long findByName(String name) {
		return getEntityManager()
				.createQuery("select count(*) from Category c where c.name = '" + name + "'", Long.class)
				.getSingleResult();
	}

}
