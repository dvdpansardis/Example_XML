package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

/**
 * 
 * A principal desvantagem do JAX-B � que os arquivos tamb�m s�o interpretados 
 * usando �rvores, ou seja, possu�mos os mesmos problemas do DOM. Quando 
 * o arquivo � muito grande, acabamos gastando muita mem�ria, portanto o
 * JAX-B � interessante para quando temos arquivos pequenos 
 * e vamos usar todas as informa��es deste arquivo.
 * 
 * @author David
 *
 */
public class MapperXML {

	public static void main(String[] args) throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		xmlToObj(jaxbContext);
		
		objToXml(jaxbContext);
		
	}

	private static void objToXml(JAXBContext jaxbContext) throws Exception {

		Venda venda = new Venda();
		
		venda.setFormaDePagamento("Cr�dito");
		
		List<Produto> produtos = new ArrayList<>();
		
		Produto produto = new Produto();
		
		produto.setNome("Xbox");
		produto.setPreco(2000.0);
		
		produtos.add(produto);
		
		produto = new Produto();
		
		produto.setNome("PlayStation");
		produto.setPreco(2500.0);
		
		produtos.add(produto);
		
		venda.setProdutos(produtos);
		
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		
		System.out.println(writer);
	}

	private static void xmlToObj(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda vendas = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		
		System.out.println(vendas);
	}

}
