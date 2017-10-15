package com.techshop.web.service;

import java.util.List;

import javax.ejb.Stateless;

import com.techshop.web.entity.Product;

@Stateless
public interface ProductService {
	public ProductGroup getProductGroup(Long categoryType, Integer numsOfProduct);
	public List<Product> getProductsByCategory(Long categoryId);
}
