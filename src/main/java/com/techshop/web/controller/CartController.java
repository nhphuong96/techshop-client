package com.techshop.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.techshop.web.base.Constants;
import com.techshop.web.model.CartProductModel;
import com.techshop.web.model.ProductModel;

@ManagedBean
@SessionScoped
@URLMapping(id = "cart", pattern = "/gio-hang", viewId = "/web/cart.xhtml")
public class CartController {

	private static final Integer DEFAULT_QUANTITY = 1;

	private List<CartProductModel> products;

	private List<Integer> quantityListSelection;

	private Integer temporaryTotalPrice;

	private Integer actualTotalPrice;

	private Integer quantity;

	@PostConstruct
	private void init() {
		products = new ArrayList<>();
		quantityListSelection = Arrays.asList(1, 2, 3, 4);
	}

	public void addProductToCart(ProductModel productModel) throws IOException {
		CartProductModel existingProduct = null;
		for (CartProductModel cpm : products) {
			if (cpm.getProductInCart().getAlias().equals(productModel.getAlias())) {
				existingProduct = cpm;
			}
		}
		if (existingProduct != null) {
			existingProduct.setQuantity(existingProduct.getQuantity() + 1);

		} else {
			CartProductModel cartProductModel = new CartProductModel();
			cartProductModel.setProductInCart(productModel);
			cartProductModel.setQuantity(DEFAULT_QUANTITY);
			products.add(cartProductModel);
		}
		updateActualPrice();
		FacesContext.getCurrentInstance().getExternalContext().redirect(Constants.CONTEXT_PATH + "/gio-hang");
	}

	public List<CartProductModel> getCart() {
		return products;
	}

	public Integer cartSize() {
		return products.size();
	}

	public void increaseProductQuantity(CartProductModel productModel) {
		CartProductModel existingProduct = null;
		for (CartProductModel cpm : products) {
			if (cpm.getProductInCart().getAlias().equals(productModel.getProductInCart().getAlias())) {
				existingProduct = cpm;
			}
		}
		if (existingProduct != null) {
			if (existingProduct.getQuantity() < 10) {
				existingProduct.setQuantity(existingProduct.getQuantity() + 1);
			}
		} else {
			return;
		}
		updateActualPrice();
	}

	public void descreaseProductQuantity(CartProductModel productModel) {
		CartProductModel existingProduct = null;
		for (CartProductModel cpm : products) {
			if (cpm.getProductInCart().getAlias().equals(productModel.getProductInCart().getAlias())) {
				existingProduct = cpm;
			}
		}
		if (existingProduct != null) {
			if (existingProduct.getQuantity() > 1) {
				existingProduct.setQuantity(existingProduct.getQuantity() - 1);
			}
		} else {
			return;
		}
		updateActualPrice();
	}

	public void removeProductFromCart(CartProductModel cartProductModel) {
		if (products.contains(cartProductModel)) {
			products.remove(cartProductModel);
		}
		updateActualPrice();
	}

	public void updateActualPrice() {
		actualTotalPrice = 0;
		for (CartProductModel cpm : products) {
			actualTotalPrice += cpm.getQuantity() * Integer.valueOf(cpm.getProductInCart().getPrice());
		}
	}

	public List<CartProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<CartProductModel> products) {
		this.products = products;
	}

	public Integer getTemporaryTotalPrice() {
		return temporaryTotalPrice;
	}

	public void setTemporaryTotalPrice(Integer temporaryTotalPrice) {
		this.temporaryTotalPrice = temporaryTotalPrice;
	}

	public Integer getActualTotalPrice() {
		return actualTotalPrice;
	}

	public void setActualTotalPrice(Integer actualTotalPrice) {
		this.actualTotalPrice = actualTotalPrice;
	}

	public List<Integer> getQuantityListSelection() {
		return quantityListSelection;
	}

	public void setQuantityListSelection(List<Integer> quantityListSelection) {
		this.quantityListSelection = quantityListSelection;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
