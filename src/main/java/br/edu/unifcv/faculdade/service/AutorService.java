package br.edu.unifcv.faculdade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifcv.faculdade.model.Autor;
import br.edu.unifcv.faculdade.repository.AutorRepository;
import br.edu.unifcv.faculdade.repository.LivroRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorrepository;
	
	@Autowired
	private LivroRepository livrorepository;
	
	public List<Autor> getAll(){
		return autorrepository.findAll();
	}
	
	public Autor findupdate(Autor autor, Long id) {
		autorrepository.findById(id).map(a -> {
			a.setNome(autor.getNome()); 
			a.setNacionalidade(autor.getNacionalidade()); 
			return autorrepository.save(a);
			
		});
		return autor;
	}
	
	public void delete(Long id) {
		autorrepository.deleteById(id);
	}
	
	public Autor save(Autor autor) {
		Autor a = autorrepository.save(autor);
		return a;
	}
	

}
