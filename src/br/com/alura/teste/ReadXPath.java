package br.com.alura.teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import br.com.alura.model.Product;

public class ReadXPath {
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//Active validating XML on factory
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/vendas.xml");
		
		//Get more of one element XPath
		System.out.println("->Name of products by Model using Xpath");
		//String exp = "/venda/produtos/produto[1]";
		//String exp = "/venda/produtos/produto[nome = 'Livro XML']";
		String exp = "/venda/produtos/produto[contains(nome,'XML')]";
		XPath xPath = XPathFactory.newInstance().newXPath();
		XPathExpression xPathExpression = xPath.compile(exp);
		
		NodeList products = (NodeList)xPathExpression.evaluate(document, XPathConstants.NODESET);
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
