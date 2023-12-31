package ex_02;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List<Livro> livros = new ArrayList<>();
	
	public Biblioteca() {
		
	}
	
	public void cadastrarLivro(String titulo, String autor, Integer anoPublicacao) {
		livros.add(new Livro(titulo, autor, anoPublicacao));
	}
	
	public void listarLivros() {
		for (Livro livro : livros) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.printf("Titulo: %s\n", livro.getTitulo());
			System.out.printf("Escrito por: %s\n", livro.getAutor());
			System.out.printf("Ano de publica��o: %d\n", livro.getAnoPublicacao());
		}
	}
	
	public List<Livro> buscarLivroPorAutor(String autor) {
		List<Livro> listaLivros = new ArrayList<>();
		for (Livro livro : livros) {
			if (livro.getAutor() == autor) {
				listaLivros.add(livro);
			}
		}
		
		return listaLivros;
	}

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.cadastrarLivro("O Morro dos Ventos Uivantes", "Emily Bront�", 1847);
		biblioteca.cadastrarLivro("Grande Sert�o Veredas", "Jo�o Guimar�es Rosa", 1956);
		biblioteca.cadastrarLivro("O Senhor das Moscas", "William Golding", 1954);
		biblioteca.cadastrarLivro("A Hora dos Ruminantes", "Jos� J. Veiga", 1966);
		biblioteca.cadastrarLivro("O Burrinho Pedr�s", "Jo�o Guimar�es Rosa", 1946);
		biblioteca.cadastrarLivro("Admir�vel Mundo Novo", "Aldous Huxley", 1932);
		biblioteca.cadastrarLivro("1984", "George Orwell", 1949);
		
		biblioteca.listarLivros();
		
		List<Livro> listaLivros = biblioteca.buscarLivroPorAutor("Jo�o Guimar�es Rosa");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		System.out.println("Livros do autor Jo�o Guimar�es Rosa dispon�veis:");
		for (Livro livro : listaLivros) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.printf("Titulo: %s\n", livro.getTitulo());
			System.out.printf("Escrito por: %s\n", livro.getAutor());
			System.out.printf("Ano de publica��o: %d\n", livro.getAnoPublicacao());
		}

	}
}
