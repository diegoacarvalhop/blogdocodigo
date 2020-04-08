package br.com.blogdocodigo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
@Entity
@Table(name = "CATEGORIAS")	
public class Categoria extends AbstractModel<Long> {

	@NotBlank
	@Size(min = 3, max = 60)
	private String nome;

	@OneToMany(mappedBy = "categoria")
	private List<Post> posts;

}
