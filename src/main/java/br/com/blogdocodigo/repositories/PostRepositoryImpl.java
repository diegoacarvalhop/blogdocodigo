package br.com.blogdocodigo.repositories;

import java.util.List;

import br.com.blogdocodigo.abstracts.AbstractRepository;
import org.springframework.stereotype.Repository;

import br.com.blogdocodigo.entities.Post;

@Repository
public class PostRepositoryImpl extends AbstractRepository<Post, Long> implements PostRepository {

    @Override
    public List<Post> findByTitle(String title) {
        return createQuery("select p from Post p where p.title like concat('%', ?1, '%')", title);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return createQuery("select p from Post p where p.author like concat('%', ?1, '%')", author);
    }

    @Override
    public List<Post> findByCategoryId(Long id) {
        return createQuery("select p from Post p where p.category.id = ?1", id);
    }

	public long count() {
		return getEntityManager().createQuery("select count(*) from Post", Long.class).getSingleResult();
	}
	
}
