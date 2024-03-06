package com.prj.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prj.api.exceptions.ApiResponse;
import com.prj.api.payloads.ProductDto;
import com.prj.api.services.ProductServices;
import com.prj.api.servicesImp.ProductServicesImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductServices prdServices;
	
	@PostMapping("/{catId}")
	@ResponseBody
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto prdDto,@PathVariable Long catId)
	{
		ProductDto prd = this.prdServices.createProduct(prdDto,catId);
		return new ResponseEntity<ProductDto>(prd,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<ProductDto>> viewall(){
		List<ProductDto> all = this.prdServices.viewAll();
		return new ResponseEntity<List<ProductDto>>(all,HttpStatus.OK);
	}
	@GetMapping("/{prdId}")
	@ResponseBody
	public ResponseEntity<ProductDto> finbyid(@PathVariable Long prdId){
		ProductDto prd = this.prdServices.findProductById(prdId);
		return new ResponseEntity<ProductDto>(prd,HttpStatus.OK);
	}
	@DeleteMapping("/{prdId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Long prdId){
		this.prdServices.deleteProduct(prdId);
		return new ResponseEntity<ApiResponse>(HttpStatus.OK);	
	}
	@PutMapping("/{prdId}")
	@ResponseBody
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto prdDto,@PathVariable Long prdId)
	{
		ProductDto prd = this.prdServices.updateProduct(prdId, prdDto);
		return new ResponseEntity<ProductDto>(prd,HttpStatus.CREATED);
	}
	@GetMapping("/category/{catId}")
	@ResponseBody
	public ResponseEntity<List<ProductDto>> finbycat(@PathVariable Long catId){
		List<ProductDto> prd = this.prdServices.findByCat(catId);
		return new ResponseEntity<List<ProductDto>>(prd,HttpStatus.OK);
	}
	
	
}
