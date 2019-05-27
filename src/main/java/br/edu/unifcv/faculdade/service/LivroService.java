package br.edu.unifcv.faculdade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifcv.faculdade.model.Livro;
import br.edu.unifcv.faculdade.repository.AutorRepository;
import br.edu.unifcv.faculdade.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livrorepository;
	
	@Autowired
	private AutorRepository autorrepository;
	
	public List<Livro> getAll(){
		return livrorepository.findAll();
	}
	
	public Livro save(Livro livro, Long id) {
		autorrepository.findById(id).map(autor -> {
			livro.setAutor(autor);
			return livrorepository.save(livro);
		});
		return livro;
	}
	
	public Livro updatelivro(Livro livro, Long idlivro) {
		livrorepository.findById(idlivro).map(l -> {
			l.setEditora(livro.getEditora());
			l.setNome(livro.getNome());
			l.setResumo(livro.getResumo());
			return livrorepository.save(l);
		});
		return livro;
	}
	
	public void delete(Long id) {
		livrorepository.deleteById(id);
	}
	

}
