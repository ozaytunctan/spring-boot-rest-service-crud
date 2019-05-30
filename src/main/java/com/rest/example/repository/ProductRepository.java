package com.rest.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.example.dto.ProductDto;
import com.rest.example.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select new com.rest.example.dto.ProductDto(p.id,p.name,p.price) from Product p ")
	List<ProductDto> getProducts();

	@Query(value = "select new com.rest.example.dto.ProductDto(p.id,p.name,p.price) from Product p where p.name like %:productName% ")
	List<ProductDto> getProductsByName(@Param("productName") String productName);

}
