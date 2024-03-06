package com.prj.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.api.model.Category;
import com.prj.api.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	List<Product> findByCategory(Category category);


}
