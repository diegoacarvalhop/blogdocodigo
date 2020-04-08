package br.com.blogdocodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.blogdocodigo.model.Categoria;
import br.com.blogdocodigo.service.CategoriaService;
import br.com.blogdocodigo.util.PaginacaoUtil;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Categoria categoria) {
		return "categoria/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("dir") Optional<String> dir) {
		int paginaAtual = page.orElse(1);
		String ordem = dir.orElse("asc");
		PaginacaoUtil<Categoria> pageCategoria = service.buscarPorPagina(paginaAtual, ordem);
		model.addAttribute("pageCategoria", pageCategoria);
		return "categoria/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Categoria categoria, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "categoria/cadastro";
		}
		if(service.buscarPorNome(categoria.getNome()) > 0) {
			attr.addFlashAttribute("error", "Já existe uma categoria com esse nome.");
			return "redirect:/categorias/cadastrar";
		}
		service.salvar(categoria);
		attr.addFlashAttribute("success", "Categoria cadastrada.");
		return "redirect:/categorias/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("categoria", service.buscarPorId(id));
		return "categoria/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Categoria categoria, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/categoria/cadastro";
		}
		service.editar(categoria);
		attr.addFlashAttribute("success", "Categoria atualizada.");
		return "redirect:/categorias/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (service.categoriaTemPosts(id)) {
			attr.addFlashAttribute("error", "Categoria não excluida. Tem post(s) vinculado(s).");
		} else {
			service.excluir(id);
			attr.addFlashAttribute("success", "Categoria excluida.");
		}
		return "redirect:/categorias/listar";
	}

}
