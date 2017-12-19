package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProductHandler;

public class ReadSAX {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProductHandler xmlReaderHandler = new ProductHandler();
		reader.setContentHandler(xmlReaderHandler);
		FileInputStream fileInputStream = new FileInputStream("src/vendas.xml");
		InputSource inputSource = new InputSource(fileInputStream);
		reader.parse(inputSource);
		
		System.out.println(xmlReaderHandler.getProducts());
	}

}
