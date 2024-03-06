package com.prj.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.api.model.Category;

public interface categoryRepo extends JpaRepository<Category, Long> {

}
