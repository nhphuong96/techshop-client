package com.techshop.web.service;

import java.util.List;

import com.techshop.web.entity.Category;
import com.techshop.web.entity.Product;

public class ProductGroup {

	private Category categoryId;
	private List<Product> products;
	
	public ProductGroup() {}
	
	public ProductGroup(Category categoryId, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.products = products;
	}

	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
