package br.com.blogdocodigo.entities;

import br.com.blogdocodigo.abstracts.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CATEGORIES")
@SuppressWarnings("serial")
public class Category extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 30)
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Post> posts;

}
