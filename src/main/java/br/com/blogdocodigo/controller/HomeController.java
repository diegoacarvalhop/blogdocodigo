package br.com.blogdocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.blogdocodigo.service.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService service;

    @GetMapping("/")
    public String home(ModelMap model) {
		model.addAttribute("posts", service.buscarTodosHome());
		return "home";
	}
    
}
