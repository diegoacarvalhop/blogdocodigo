package br.com.blogdocodigo.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginacaoUtil<T> {

	private int tamanho;
	private int pagina;
	private long totalDePaginas;
	private String direcao;
	private List<T> registros;
	private List<Integer> numerosPaginas;

	public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas, String direcao, List<T> registros,
			List<Integer> numeroPaginas) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalDePaginas = totalDePaginas;
		this.direcao = direcao;
		this.registros = registros;
		this.numerosPaginas = numeroPaginas;
	}

	public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas, List<T> registros, List<Integer> numeroPaginas) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalDePaginas = totalDePaginas;
		this.registros = registros;
		this.numerosPaginas = numeroPaginas;
	}

}
