package com.techshop.web.service;

import java.util.List;

import com.techshop.web.entity.Category;
import com.techshop.web.entity.ProductInformation;

public class ProductGroup {

	private Category categoryId;
	private List<ProductInformation> products;
	
	public ProductGroup() {}
	
	public ProductGroup(Category categoryId, List<ProductInformation> products) {
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
	public List<ProductInformation> getProducts() {
		return products;
	}
	public void setProducts(List<ProductInformation> products) {
		this.products = products;
	}
	
}
