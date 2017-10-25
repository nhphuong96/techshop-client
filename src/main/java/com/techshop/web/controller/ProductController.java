package com.techshop.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.techshop.web.model.ProductModel;
import com.techshop.web.service.ProductService;

@ManagedBean(name="product")
@ViewScoped
@URLMapping( id="mobile", pattern="/dien-thoai/#{product.mobileAlias}", viewId="/web/product_detail.xhtml")
public class ProductController {
	
	private ProductModel selectedProduct;
	
	private String mobileAlias;

	@EJB
	private ProductService productService;
	
	@URLAction(mappingId="mobile", onPostback=false)
	public void loadSelectedMobile() {
		if (mobileAlias == null) {
			return;
		}
		selectedProduct = productService.getProductsByAlias(mobileAlias);
	}
	
	
	public ProductModel getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(ProductModel selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	public String getMobileAlias() {
		return mobileAlias;
	}

	public void setMobileAlias(String mobileAlias) {
		this.mobileAlias = mobileAlias;
	}
}
