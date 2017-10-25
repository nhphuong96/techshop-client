package com.techshop.web.model;

import java.util.List;

public class ProductModel {
	private String productName;
	private String alias;
	private String descriptionHTML;
	private String image1;
	private String image2;
	private String image3;
	private String price;
	private List<SpecificationModel> specificationInfos;
	private Long manufacturerId;
	private Long categoryId;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescriptionHTML() {
		return descriptionHTML;
	}
	public void setDescriptionHTML(String descriptionHTML) {
		this.descriptionHTML = descriptionHTML;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<SpecificationModel> getSpecificationInfos() {
		return specificationInfos;
	}
	public void setSpecificationInfos(List<SpecificationModel> specificationInfos) {
		this.specificationInfos = specificationInfos;
	}
	public Long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
