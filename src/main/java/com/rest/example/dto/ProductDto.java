package com.rest.example.dto;

public class ProductDto {

	private Integer productId;

	private String productName;

	private Double productPrice;

	
	
	public ProductDto() {
		this.setProductId(0);
	}
	
	

	public ProductDto(Integer productId, String productName, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}



	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product[").append("productId=").append(this.productId).append(",").append("name=")
				.append(this.productName).append(",").append("price=").append(this.productPrice).append("]");
		return builder.toString();
	}

}
