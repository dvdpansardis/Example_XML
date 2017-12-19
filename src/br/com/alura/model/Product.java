package br.com.alura.model;

public class Product {

	private String productNameValue;
	private Double productPriceValue;

	public Product(String productNameValue, Double productPriceValue) {
		this.productNameValue = productNameValue;
		this.productPriceValue = productPriceValue;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProductNameValue() {
		return productNameValue;
	}

	public Double getProductPriceValue() {
		return productPriceValue;
	}
	
	@Override
	public String toString() {
		return String.format("\n Name: %s \n price: %.2f \n", productNameValue, productPriceValue);
	}

	public void setProductNameValue(String productNameValue) {
		this.productNameValue = productNameValue;
	}

	public void setProductPriceValue(Double productPriceValue) {
		this.productPriceValue = productPriceValue;
	}
	
	

}
