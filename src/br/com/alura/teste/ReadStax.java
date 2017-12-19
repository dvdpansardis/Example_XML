package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Product;

public class ReadStax {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		InputStream inputStream = new FileInputStream("src/vendas.xml");
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);

		List<Product> products = new ArrayList<>();

		while (xmlEventReader.hasNext()) {

			XMLEvent xmlEvent = xmlEventReader.nextEvent();

			if (xmlEvent.isStartElement() && xmlEvent.asStartElement().getName().getLocalPart().equals("produto")) {
				products.add(createNewProduct(xmlEventReader));
			}
		}

		System.out.println(products);
	}

	private static Product createNewProduct(XMLEventReader xmlEventReader) throws XMLStreamException {
		Product product = new Product();

		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			if (xmlEvent.isStartElement() && xmlEvent.asStartElement().getName().getLocalPart().equals("nome")) {
				xmlEvent = xmlEventReader.nextEvent();
				String content = xmlEvent.asCharacters().getData();
				product.setProductNameValue(content);
			} else if (xmlEvent.isStartElement()
					&& xmlEvent.asStartElement().getName().getLocalPart().equals("preco")) {
				xmlEvent = xmlEventReader.nextEvent();
				String content = xmlEvent.asCharacters().getData();
				product.setProductPriceValue(Double.valueOf(content));
			} else if (xmlEvent.isEndElement() && xmlEvent.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
		}
		return product;
	}

}
