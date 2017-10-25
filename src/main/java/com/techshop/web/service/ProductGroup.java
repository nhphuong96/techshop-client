package com.techshop.web.service;

import java.util.List;

import com.techshop.web.entity.Category;
import com.techshop.web.model.ProductModel;

public class ProductGroup {

	private Category categoryId;
	private List<ProductModel> products;
	
	public ProductGroup() {}
	
	public ProductGroup(Category categoryId, List<ProductModel> products) {
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
	public List<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}
	
}
