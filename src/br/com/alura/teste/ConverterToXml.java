package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConverterToXml {

	public static void main(String[] args) throws Exception {
		InputStream xsl = new FileInputStream("src/xmlToHtml.xsl");
		InputStream data = new FileInputStream("src/vendas.xml");
		
		StreamSource xslSource = new StreamSource(xsl); 
		StreamSource xmlSource = new StreamSource(data);

		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		
		StreamResult result = new StreamResult("src/vendas.html");
		transformer.transform(xmlSource, result);
		
		System.out.println("Finish");
	}

}
