package br.edu.unifcv.faculdade.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unifcv.faculdade.model.Livro;
import br.edu.unifcv.faculdade.service.LivroService;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroservice;
	
	@RequestMapping(path = "/livros")
	public List<Livro>findAll() {
		return livroservice.getAll();
	}
	
	@RequestMapping(path = "/cadastrolivro/{idautor}", method= RequestMethod.POST)
	public ResponseEntity<Livro> save(
			@PathVariable Long idautor,
			@RequestBody Livro livro){
		Livro l = livroservice.save(livro, idautor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(l.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path= "/update/{idlivro}", method= RequestMethod.PUT)
	public Livro updatelivro(
			@PathVariable Long idlivro,
			@RequestBody Livro livro) {
		return livroservice.updatelivro(livro, idlivro);
	}
	
	@RequestMapping(path= "/delete/{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		livroservice.delete(id);
	}

}
