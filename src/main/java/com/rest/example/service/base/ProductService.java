package com.rest.example.service.base;

import java.util.List;

import com.rest.example.dto.ProductDto;

public interface ProductService {

	/**
	 * Yeni bir ürün eklemek için kullanılan servis metodudur.
	 * 
	 * @param product
	 * @return ProductDto.java
	 */
	ProductDto addProduct(ProductDto product);

	/**
	 * Ürün id bilgisine göre ilgili ürünü silen metod.
	 * 
	 * @param productId
	 * @return
	 */
	boolean deleteProduct(Integer productId);

	/**
	 * Ürün id bilgisine göre ilgili ürün verilerini güncelleyen servis metodudur.
	 * 
	 * @param productId
	 * @param update
	 * @return
	 */
	ProductDto updateProduct(Integer productId, ProductDto update);

	/**
	 * Bütün ürünlerin listesini return eden servis metodudur.
	 * 
	 * @return
	 */
	List<ProductDto> getAllProcuts();

	/**
	 * Ürün ismine göre ürünleri return eden servis metodudur.
	 * 
	 * @param productName
	 * @return
	 */
	List<ProductDto> getProductsByName(String productName);

}
