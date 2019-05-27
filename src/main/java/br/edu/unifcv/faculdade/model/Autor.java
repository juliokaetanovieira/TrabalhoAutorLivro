package br.edu.unifcv.faculdade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Autor extends BaseEntity {
	
	private String nome;
	@Column(length = 100)
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")
	
	private List<Livro> livros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	


}
