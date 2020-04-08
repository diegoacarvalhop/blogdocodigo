package br.com.blogdocodigo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.blogdocodigo.model.Categoria;
import br.com.blogdocodigo.model.Post;
import br.com.blogdocodigo.service.CategoriaService;
import br.com.blogdocodigo.service.PostService;
import br.com.blogdocodigo.util.PaginacaoUtil;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService service;

	@Autowired
	private CategoriaService serviceCategoria;

	@GetMapping("/cadastrar")
	public String cadastrar(Post post) {
		return "post/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		int paginaAtual = page.orElse(1);
		PaginacaoUtil<Post> pagePost = service.buscarPorPagina(paginaAtual);
		model.addAttribute("pagePost", pagePost);
		return "post/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "post/cadastro";
		}
		if(service.buscarPorTitulo(post.getTitulo()).size() > 0) {
			attributes.addFlashAttribute("error", "Já existe um post com esse título.");
			return "redirect:/posts/cadastrar";
		}
		post.setData(LocalDate.now());
		service.salvar(post);
		attributes.addFlashAttribute("success", "Post cadastrado.");
		return "redirect:/posts/cadastrar";
	}

	@ModelAttribute("categorias")
	public List<Categoria> listaCategorias(ModelMap model) {
		return serviceCategoria.buscarTodos();
	}

	@GetMapping("editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("post", service.buscarPorId(id));
		return "post/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "post/cadastro";
		}
		service.editar(post);
		attributes.addFlashAttribute("success", "Post atualizado.");
		return "redirect:/posts/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
		service.excluir(id);
		attributes.addFlashAttribute("success", "Post exluído.");
		return "redirect:/posts/listar";
	}

	@GetMapping("/buscar/titulo")
	public String getPorTitulo(@RequestParam("titulo") String titulo, ModelMap model) {
		model.addAttribute("posts", service.buscarPorTitulo(titulo));
		return "post/lista";
	}

	@GetMapping("/buscar/autor")
	public String getPorAutor(@RequestParam("autor") String autor, ModelMap model) {
		model.addAttribute("posts", service.buscarPorAutor(autor));
		return "post/lista";
	}

	@GetMapping("/buscar/categoria")
	public String getPorCategoria(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("posts", service.buscarPorCategoria(id));
		return "post/lista";
	}

}
