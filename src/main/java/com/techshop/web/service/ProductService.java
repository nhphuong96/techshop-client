package com.techshop.web.service;

import java.util.List;

import javax.ejb.Stateless;

import com.techshop.web.entity.ProductInformation;

@Stateless
public interface ProductService {
	public ProductGroup getProductGroupById(Long categoryType);
	public ProductGroup getProductGroupByAlias(String alias);
	public List<ProductInformation> getProductsByCategory(Long categoryId);
}
