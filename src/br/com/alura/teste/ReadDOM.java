package br.com.alura.teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.model.Product;

public class ReadDOM {
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//Active validating XML on factory
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/vendas.xml");
		
		//Get one element
		NodeList typePayments = document.getElementsByTagName("formaDePagamento");
		Element typePayment = (Element) typePayments.item(0);
		String typePaymentValue = typePayment.getTextContent();
		System.out.println("->Type payment");
		System.out.println(typePaymentValue);
		
		//Get more of one element
		System.out.println("->Name of products");
		NodeList productNames = document.getElementsByTagName("nome");
		for (int i = 0; i < productNames.getLength(); i++) {
			Element productName = (Element) productNames.item(i);
			String productNameValue = productName.getTextContent(); 
			System.out.println(productNameValue);
		}
		
		//Get more of one element
		System.out.println("->Name of products by Model");
		NodeList products = document.getElementsByTagName("produto");
		for (int i = 0; i < products.getLength(); i++) {
			Element product = (Element) products.item(i);
			String productNameValue = product.getElementsByTagName("nome").item(0).getTextContent();
			Double productPriceValue = Double.valueOf(product.getElementsByTagName("preco").item(0).getTextContent());
			Product productModel = new Product(productNameValue, productPriceValue);
			System.out.println(productModel);
		}
		
		//Get Attributes
		Element attrCoin = document.getDocumentElement();
		String attrCoinValue = attrCoin.getAttribute("moeda");
		System.out.println("Coin used: " + attrCoinValue);
	}
}
