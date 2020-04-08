package br.com.blogdocodigo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
@Entity
@Table(name = "POSTS")
public class Post extends AbstractModel<Long> {

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_categoria_fk")
	private Categoria categoria;

	@NotBlank
	@Size(min = 3, max = 255)
	private String autor;

	@NotBlank
	@Size(min = 3, max = 60)
	@Column(unique = true)
	private String titulo;

	@NotBlank
	@Lob
	private String conteudo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate data;

}
