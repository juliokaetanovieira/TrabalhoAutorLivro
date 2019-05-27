package br.edu.unifcv.faculdade.controller;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unifcv.faculdade.model.Autor;
import br.edu.unifcv.faculdade.service.AutorService;
import br.edu.unifcv.faculdade.service.LivroService;

@RestController
@RequestMapping(path = "/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorservice;
	
	@Autowired
	private LivroService livroservice;
	
	@RequestMapping(path="/todosautor")
	public List<Autor>findAll(){
		return autorservice.getAll();
	}
	
	@RequestMapping(path="/cadastroautor", method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Autor autor){
		Autor a = autorservice.save(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public Autor updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
		return autorservice.findupdate(autor, id);
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		autorservice.delete(id);
	}

}
