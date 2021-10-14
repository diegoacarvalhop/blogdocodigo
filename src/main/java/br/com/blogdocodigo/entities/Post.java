package br.com.blogdocodigo.entities;

import br.com.blogdocodigo.abstracts.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@SuppressWarnings("serial")
@Entity
@Table(name = "POSTS")
public class Post extends AbstractEntity<Long> {

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;

	@NotBlank
	@Size(min = 3, max = 60)
	private String author;

	@NotBlank
	@Size(min = 3, max = 60)
	private String title;

	@NotBlank
	@Lob
	private String contents;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate date;

}
