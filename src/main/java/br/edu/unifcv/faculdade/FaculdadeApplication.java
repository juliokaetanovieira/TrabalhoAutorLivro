package br.edu.unifcv.faculdade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaculdadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaculdadeApplication.class, args);
		
		System.out.println("Preencha com o nome do livro:");
	}

}
