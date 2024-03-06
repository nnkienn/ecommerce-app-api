package com.prj.api.servicesImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.api.exceptions.ResourceNotFoundException;
import com.prj.api.model.Category;
import com.prj.api.model.Product;
import com.prj.api.payloads.ProductDto;
import com.prj.api.repositories.ProductRepo;
import com.prj.api.repositories.categoryRepo;
import com.prj.api.services.ProductServices;
@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	private ProductRepo proRepo;
	

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private categoryRepo catRepo;


	@Override
	public ProductDto createProduct(ProductDto productDto, Long catId) {
		Category cat = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("cat","cat id",catId));
		Product product = this.modelMapper.map(productDto, Product.class);
		product.setCategory(cat);
		Product newPrd= this.proRepo.save(product);
		return this.modelMapper.map(newPrd, ProductDto.class);
	}


	@Override
	public List<ProductDto> viewAll() {
		List<Product> all = this.proRepo.findAll();
		List<ProductDto> allDtos = all.stream().map(prd->this.modelMapper.map(prd, ProductDto.class)).collect(Collectors.toList());
		return allDtos;
	}


	@Override
	public ProductDto findProductById(Long productId) {
		Product prd = this.proRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("prd","prd id",productId));
		
		return this.modelMapper.map(prd, ProductDto.class);
	}


	@Override
	public void deleteProduct(Long productId) {
		this.proRepo.deleteById(productId);
	}


	@Override
	public ProductDto updateProduct(Long productId, ProductDto productDto) {
		Product prd = this.proRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("prd","prd id",productId));
		Product product = this.modelMapper.map(prd, Product.class);
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		proRepo.save(product);
		return this.modelMapper.map(product, ProductDto.class);
	}


	@Override
	public List<ProductDto> findByCat(Long catId) {
		Category cat = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("cat","cat id",catId));
		List<Product> products = this.proRepo.findByCategory(cat);
		List<ProductDto> productDtos = products.stream().map((prd)->this.modelMapper.map(prd, ProductDto.class)).collect(Collectors.toList());
		return productDtos;
	}

	

}
