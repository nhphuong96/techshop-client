package com.techshop.web.service;

import java.util.List;

import com.techshop.web.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategory();
	public Category getById(Long id);
	public Category getByAlias(String alias);
}
