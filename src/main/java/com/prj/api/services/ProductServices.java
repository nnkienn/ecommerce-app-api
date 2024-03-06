package com.prj.api.services;



import java.util.List;

import com.prj.api.model.Product;
import com.prj.api.payloads.ProductDto;

public interface ProductServices {
	ProductDto createProduct(ProductDto product,Long catId);
	List<ProductDto> viewAll();
	ProductDto findProductById(Long productId);
	void deleteProduct(Long productId);
	ProductDto updateProduct(Long productId, ProductDto productDto);
	List<ProductDto> findByCat(Long catId);
}
