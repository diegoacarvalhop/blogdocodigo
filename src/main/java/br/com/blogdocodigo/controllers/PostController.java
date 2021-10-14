package br.com.blogdocodigo.controllers;

import br.com.blogdocodigo.entities.Category;
import br.com.blogdocodigo.services.CategoryService;
import br.com.blogdocodigo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService service;

	@Autowired
	private CategoryService serviceCategory;

	@GetMapping("/findAll")
	public String findAll() {
		return "";
	}

	@GetMapping("/findById/{id}")
	public ModelAndView findById() {
		return null;
	}

	@PostMapping("/save")
	public String save() {
		return "";
	}

	@ModelAttribute("listCategories")
	public List<Category> listCategories() {
		return null;
	}

	@GetMapping("edit/{id}")
	public String preEdit() {
		return "";
	}

	@PostMapping("/edit")
	public String edit() {
		return "";
	}

	@GetMapping("/delete/{id}")
	public String delete() {
		return "";
	}

	@GetMapping("/findByTitle")
	public String findByTitle() {
		return "";
	}

	@GetMapping("/findByAuthor")
	public String findByAuthor() {
		return "";
	}

	@GetMapping("/findByCategory")
	public String findByCategory() {
		return "";
	}

}
