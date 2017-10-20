package com.techshop.web.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import com.techshop.web.base.Constants;
import com.techshop.web.entity.Category;
import com.techshop.web.service.CategoryService;
import com.techshop.web.utils.GsonParser;

@Stateless
public class CategoryServiceImpl implements CategoryService {
	
	private static String GET_ALL_CATEGORY_API = Constants.PATH + Constants.CATEGORY + Constants.GET_ALL;
	private static String GET_CATEGORY_API = Constants.PATH + Constants.CATEGORY + Constants.GET + "?" + Constants.ID + "=";
	

	@Override
	public List<Category> getAllCategory() {
		Category[] result = GsonParser.getResult(GET_ALL_CATEGORY_API, Category[].class);
		return Arrays.asList(result);
	}

	@Override
	public Category getById(Long id) {
		return GsonParser.getResult(GET_CATEGORY_API + id ,Category.class);
	}

	@Override
	public Category getByAlias(String alias) {
		List<Category> allCategories =  Arrays.asList(GsonParser.getResult(GET_ALL_CATEGORY_API, Category[].class));
		Category targetCategory = allCategories.stream()
				.filter(p -> p.getAlias().equals(alias)).collect(Collectors.toList()).get(0);
		return targetCategory;
	}
	
}
