package com.techshop.web.service.impl;

import java.util.List;

import com.techshop.web.base.Constants;
import com.techshop.web.entity.Product;
import com.techshop.web.service.ProductGroup;
import com.techshop.web.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private static String GET_ALL_PRODUCT_API = Constants.PATH + Constants.CATEGORY + Constants.GET_ALL;

	@Override
	public List<Product> getProductsByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductGroup getProductGroup(Long categoryType, Integer numsOfProduct) {
		
		return null;
	}
	
}
