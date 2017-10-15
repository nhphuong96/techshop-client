package com.techshop.web.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import com.techshop.web.base.Constants;
import com.techshop.web.entity.Category;
import com.techshop.web.service.CategoryService;
import com.techshop.web.utils.GsonParser;

@Stateless
public class CategoryServiceImpl implements CategoryService {
	
	private static String GET_ALL_CATEGORY_API = Constants.PATH + Constants.CATEGORY + Constants.GET_ALL;

	@Override
	public List<Category> getAllCategory() throws InstantiationException, IllegalAccessException {
		Category[] result = GsonParser.getResult(GET_ALL_CATEGORY_API, Category[].class);
		return Arrays.asList(result);
	}

}
