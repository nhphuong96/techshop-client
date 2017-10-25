package com.techshop.web.service;

import java.util.List;

import javax.ejb.Stateless;

import com.techshop.web.model.ProductModel;

@Stateless
public interface ProductService {
	public ProductGroup getProductGroupById(Long categoryType);
	public ProductGroup getProductGroupByAlias(String alias);
	public List<ProductModel> getProductsByCategory(Long categoryId);
	public ProductModel getProductsByAlias(String alias);
}
