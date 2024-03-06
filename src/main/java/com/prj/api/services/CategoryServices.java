package com.prj.api.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.prj.api.model.Category;
import com.prj.api.payloads.CategoryDto;

public interface CategoryServices {
	CategoryDto createCategory(CategoryDto cate);
	CategoryDto updateCategory(Long categoryId,CategoryDto cateDto);
	List<CategoryDto> viewall();
	void deletecategory(Long categoryId);	
	List<Category> findCategoryByNameService(String name, Pageable pageable);
}
