package br.com.alura.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Indica que � o elemento "root" do xml
@XmlAccessorType(XmlAccessType.FIELD) //Para resolver o conflito entre a propriedade e o getter
public class Venda {

	private String formaDePagamento;

	@XmlElement(name="produto") //Indica quais s�o os elementos internos da lista
	@XmlElementWrapper(name="produtos") //Indica que � uma composi��o de um objeto
	private List<Produto> produtos;

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Forma de pagamento: " + formaDePagamento + " \n produtos: " + produtos;
	}
}
