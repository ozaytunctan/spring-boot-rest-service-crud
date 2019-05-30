package com.rest.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.example.dto.ProductDto;
import com.rest.example.model.Product;
import com.rest.example.repository.ProductRepository;
import com.rest.example.service.base.ProductService;

/**
 * 
 * @author otunctan
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	// @Autowired ile inject edilebilir
	private ProductRepository productRepository;

	// Constructor injection
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto addProduct(ProductDto product) {

		Product addProduct = this.productRepository
				.save(new Product(product.getProductName(), product.getProductPrice()));

		if (Objects.nonNull(addProduct) && addProduct.getId() > 0) {
			product.setProductId(addProduct.getId());
		}

		return product;
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		boolean result = false;

		if (productId > 0) {

			this.productRepository.deleteById(productId);
			result = !result;
		}

		return result;
	}

	@Override
	public ProductDto updateProduct(Integer productId, ProductDto update) {

		if (productId > 0) {

			Product p = this.productRepository.getOne(productId);
			p.setName(update.getProductName());
			p.setPrice(update.getProductPrice());

			this.productRepository.saveAndFlush(p);

			update.setProductId(productId);

		}

		return update;
	}

	@Override
	public List<ProductDto> getAllProcuts() {
		return this.productRepository.getProducts();
	}

	@Override
	public List<ProductDto> getProductsByName(String productName) {
		return this.productRepository.getProductsByName(productName);
	}

}
