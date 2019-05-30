package com.rest.example.controller;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.example.dto.ProductDto;
import com.rest.example.service.base.ProductService;

@RestController
public class ProductController {

	private Logger logger = Logger.getLogger(ProductController.class);

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;

	}

	@GetMapping(path = "/products")
	public ResponseEntity<List<ProductDto>> getAllProducts() {

		List<ProductDto> products = productService.getAllProcuts();

		if (Objects.nonNull(products) && products.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(products);

	}

	@GetMapping(path = "/products-name")
	public ResponseEntity<List<ProductDto>> getProductsByName(
			@RequestParam(name = "productName", defaultValue = "", required = true) String productName) {
		this.logger.info("ProductController.class-->getProductsByName() parameter name:" + productName);

		if (Objects.isNull(productName) || productName.equals(""))
			return ResponseEntity.badRequest().build();

		List<ProductDto> products = productService.getProductsByName(productName);

		if (Objects.nonNull(products) && products.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(products);

	}

	@PostMapping(path = "/create-product")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
		this.logger.info("ProductController.class-->createProduct() parameter:" + product);

		if (Objects.isNull(product))
			return ResponseEntity.badRequest().build();

		ProductDto productDto = productService.addProduct(product);

		if (productDto.getProductId() <= 0)
			return ResponseEntity.badRequest().build();

		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);

	}

	@PutMapping(path = "/update-product/{productId}")
	public ResponseEntity<ProductDto> updateProduct(
			@PathVariable(name = "productId", required = true) Integer productId, @RequestBody ProductDto product) {
		this.logger.info("ProductController.class-->updateProduct() parameter:" + product + ",id=" + productId);

		if (productId <= 0) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(productService.updateProduct(productId, product));

	}

	@DeleteMapping(path = "/delete-product/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(name = "productId", required = true) Integer productId) {
		this.logger.info("ProductController.class-->deleteProduct() parameter:" + productId);

		if (productId <= 0) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(productService.deleteProduct(productId));

	}

}
