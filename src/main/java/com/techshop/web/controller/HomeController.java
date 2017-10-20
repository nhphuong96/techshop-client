package com.techshop.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.techshop.web.entity.Category;
import com.techshop.web.entity.Manufacturer;
import com.techshop.web.service.CategoryService;
import com.techshop.web.service.ManufacturerService;
import com.techshop.web.service.ProductGroup;
import com.techshop.web.service.ProductService;

@ManagedBean
@ViewScoped
public class HomeController {
	
	private ProductGroup mobileList;
	private ProductGroup tabletList;
	private ProductGroup laptopList;
	private ProductGroup equipList;
	
	@EJB
	private CategoryService categoryService;

	@EJB
	private ManufacturerService manufacturerService;

	@EJB
	private ProductService productService;
	
	@PostConstruct
	public void init() {
		mobileList = productService.getProductGroupByAlias("dien-thoai");
		tabletList = productService.getProductGroupByAlias("may-tinh-bang");
		laptopList = productService.getProductGroupByAlias("laptop");
		equipList = productService.getProductGroupByAlias("phu-kien");
	}
	
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	public List<Manufacturer> getAllManufacturer() {
		return manufacturerService.getAllManufacturer();
	}
	
	public ProductGroup getMobileList() {
		return mobileList;
	}

	public void setMobileList(ProductGroup mobileList) {
		this.mobileList = mobileList;
	}

	public ProductGroup getTabletList() {
		return tabletList;
	}

	public void setTabletList(ProductGroup tabletList) {
		this.tabletList = tabletList;
	}

	public ProductGroup getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(ProductGroup laptopList) {
		this.laptopList = laptopList;
	}

	public ProductGroup getEquipList() {
		return equipList;
	}

	public void setEquipList(ProductGroup equipList) {
		this.equipList = equipList;
	}

}
