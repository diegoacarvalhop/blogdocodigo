package br.com.blogdocodigo.conversors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.blogdocodigo.entities.Category;
import br.com.blogdocodigo.services.CategoryService;

@Component
public class StringToCategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryService service;
	
	@Override
	public Category convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}
}
