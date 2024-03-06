package com.prj.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.api.exceptions.ApiResponse;
import com.prj.api.payloads.CategoryDto;
import com.prj.api.services.CategoryServices;



@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryServices cateservice;
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCate(@RequestBody CategoryDto cateDto){
		CategoryDto cate = this.cateservice.createCategory(cateDto);
		return new ResponseEntity<CategoryDto>(cate,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<CategoryDto>> viewCate(){
		List<CategoryDto> list = this.cateservice.viewall();
		return new ResponseEntity<List<CategoryDto>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto cateDto,@PathVariable Long categoryId ){
		CategoryDto cate = this.cateservice.updateCategory(categoryId, cateDto);
		return new ResponseEntity<CategoryDto>(cate,HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Long categoryId){
		this.cateservice.deletecategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("delete success",true),HttpStatus.OK);
	}
	
	
	

}
