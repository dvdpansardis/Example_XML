package br.com.alura.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Product;

public class ProductHandler extends DefaultHandler {
	
	private List<Product> products = new ArrayList<>();
	private StringBuilder content;
	private Product product;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println(qName);
		if(qName.equals("produto")){
			product = new Product();
		}
		content = new StringBuilder();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content.append(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("produto")){
			products.add(product);
		} else if(qName.equals("nome")){
			product.setProductNameValue(content.toString());
		} else if(qName.equals("preco")) {
			product.setProductPriceValue(Double.valueOf(content.toString()));
		}
	}
	
	public List<Product> getProducts() {
		return products;
	}
}
