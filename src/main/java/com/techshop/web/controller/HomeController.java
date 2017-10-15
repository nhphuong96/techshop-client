package com.techshop.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.techshop.web.entity.Category;
import com.techshop.web.entity.Manufacturer;
import com.techshop.web.service.CategoryService;
import com.techshop.web.service.ManufacturerService;

@ManagedBean
@ViewScoped
public class HomeController {

	@EJB
	private CategoryService categoryService;
	
	@EJB
	private ManufacturerService manufacturerService;
	
	public List<Category> getAllCategory() {
		try {
			return categoryService.getAllCategory();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<Manufacturer> getAllManufacturer() {
		try {
			return manufacturerService.getAllManufacturer();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
