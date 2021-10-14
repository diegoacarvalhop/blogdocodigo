package br.com.blogdocodigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blogdocodigo.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoriaController {

	@Autowired
	private CategoryService service;

	@GetMapping("/lçistAll")
	public String listAll() {
		return "";
	}

	@PostMapping("/save")
	public String save() {
		return "";
	}

	@GetMapping("/edit/{id}")
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

}
