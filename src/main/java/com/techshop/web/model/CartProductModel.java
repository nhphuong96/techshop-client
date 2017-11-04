package com.techshop.web.model;

public class CartProductModel {
	
	private ProductModel productInCart;
	private Integer quantity;
	
	public ProductModel getProductInCart() {
		return productInCart;
	}
	public void setProductInCart(ProductModel productInCart) {
		this.productInCart = productInCart;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
