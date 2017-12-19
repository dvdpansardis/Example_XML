package br.com.alura.model;

public class Produto {

	private String nome;

	private Double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return String.format("\n Name: %s \n price: %.2f \n", nome, preco);
	}

}
