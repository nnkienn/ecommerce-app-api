package com.prj.api.servicesImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prj.api.exceptions.ResourceNotFoundException;
import com.prj.api.model.Category;
import com.prj.api.payloads.CategoryDto;
import com.prj.api.repositories.categoryRepo;
import com.prj.api.services.CategoryServices;

@Service
public class CategoryServicesImpl implements CategoryServices {
	@Autowired
	private categoryRepo cateRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto cate) {
		Category cat = this.modelMapper.map(cate, Category.class);
		Category savecate= this.cateRepo.save(cat);
		return this.modelMapper.map(savecate, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(Long categoryId, CategoryDto cateDto) {
		Category cat = this.cateRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id",categoryId));
		Category cateOd = this.modelMapper.map(cat, Category.class);
		cateOd.setCategoryName(cateDto.getCategoryName());
		cateOd.setDescription(cateDto.getDescription());
		cateRepo.save(cateOd);
		
		return this.modelMapper.map(cateOd, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> viewall() {
		List<Category> cateList = this.cateRepo.findAll();
		List<CategoryDto> cate = cateList.stream().map((cat)-> this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		return cate;
	}

	@Override
	public void deletecategory(Long categoryId) {
		Category cat = this.cateRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id",categoryId));
		this.cateRepo.delete(cat);
	}

	@Override
	public List<Category> findCategoryByNameService(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
