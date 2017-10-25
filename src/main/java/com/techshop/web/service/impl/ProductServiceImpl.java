package com.techshop.web.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.techshop.web.base.Constants;
import com.techshop.web.converter.ProductConverter;
import com.techshop.web.entity.Category;
import com.techshop.web.entity.ProductInformation;
import com.techshop.web.model.ProductModel;
import com.techshop.web.service.CategoryService;
import com.techshop.web.service.ProductGroup;
import com.techshop.web.service.ProductService;
import com.techshop.web.utils.GsonParser;

@Stateless
public class ProductServiceImpl implements ProductService {
	
	private static String GET_ALL_PRODUCT_API = Constants.PATH + Constants.PRODUCT + Constants.GET_ALL;

	@EJB
	private CategoryService categoryService;
	
	@EJB
	private ProductConverter productConverter;
	
	@Override
	public List<ProductModel> getProductsByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductGroup getProductGroupById(Long categoryId) {
		List<ProductInformation> allProducts = Arrays.asList(GsonParser.getResult(GET_ALL_PRODUCT_API, ProductInformation[].class));
		List<ProductInformation> filteredProducts = allProducts.stream()
				.filter(p -> p.getCategoryId() == categoryId).collect(Collectors.toList());
		List<ProductModel> productModels = new ArrayList<>();
		for (ProductInformation pi : filteredProducts) {
			productModels.add(productConverter.convert(pi));
		}
		ProductGroup productGroup = new ProductGroup(categoryService.getById(categoryId), productModels);
		return productGroup;
	}

	@Override
	public ProductGroup getProductGroupByAlias(String alias) {
		Category category = categoryService.getByAlias(alias);
		List<ProductInformation> allProducts = Arrays.asList(GsonParser.getResult(GET_ALL_PRODUCT_API, ProductInformation[].class));
		List<ProductInformation> filteredProducts = allProducts.stream()
				.filter(p -> p.getCategoryId() == category.getId()).collect(Collectors.toList());
		List<ProductModel> productModels = new ArrayList<>();
		for (ProductInformation pi : filteredProducts) {
			productModels.add(productConverter.convert(pi));
		}
		ProductGroup productGroup = new ProductGroup(category, productModels);
		return productGroup;
	}

	@Override
	public ProductModel getProductsByAlias(String alias) {
		List<ProductInformation> allProducts = Arrays.asList(GsonParser.getResult(GET_ALL_PRODUCT_API, ProductInformation[].class));
		List<ProductInformation> filteredProducts = allProducts.stream()
				.filter(p -> p.getAlias().equals(alias)).collect(Collectors.toList());
		ProductModel pm = productConverter.convert(filteredProducts.get(0));
		return pm;
		 
	}
	
}
